package com.app.mockserver;

import com.app.config.ApplicationPropertiesLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpForward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpForward.forward;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserMockserverTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ApplicationPropertiesLoader loader;

    ClientAndServer mockServer;

    @Before
    public void startMockServer() {
        mockServer = startClientAndServer(1080);
    }

    @Test
    public void should_Find_User_By_UserName() throws Exception {
        when(loader.getUrl()).thenReturn("http://localhost:".concat(mockServer.getPort().toString()));

        mockServer
                .when(request()
                        .withMethod("GET")
                        .withPath("/users/pedrohubner")
                )
                .respond(response()
                        .withStatusCode(200)
                        .withBody("{\"login\":\"pedrohubner\",\"id\":54464720,\"node_id\":\"MDQ6VXNlcjU0NDY0NzIw\",\"avatar_url\":\"https://avatars1.githubusercontent.com/u/54464720?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/pedrohubner\",\"html_url\":\"https://github.com/pedrohubner\",\"followers_url\":\"https://api.github.com/users/pedrohubner/followers\",\"following_url\":\"https://api.github.com/users/pedrohubner/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/pedrohubner/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/pedrohubner/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/pedrohubner/subscriptions\",\"organizations_url\":\"https://api.github.com/users/pedrohubner/orgs\",\"repos_url\":\"https://api.github.com/users/pedrohubner/repos\",\"events_url\":\"https://api.github.com/users/pedrohubner/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/pedrohubner/received_events\",\"type\":\"User\",\"site_admin\":false,\"name\":\"Pedro Hübner\",\"company\":null,\"blog\":\"\",\"location\":\"Rio Grande do Sul, Brasil\",\"email\":null,\"hireable\":null,\"bio\":null,\"twitter_username\":null,\"public_repos\":6,\"public_gists\":1,\"followers\":8,\"following\":9,\"created_at\":\"2019-08-24T05:21:12Z\",\"updated_at\":\"2020-09-03T02:39:30Z\"}")
                );

        mockMvc.perform(get("/users/{userName}", "pedrohubner"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_Find_User_By_UserName_withForward() throws Exception {
        when(loader.getUrl()).thenReturn("http://localhost:".concat(mockServer.getPort().toString()));

        mockServer
                .when(request()
                        .withMethod("GET")
                        .withPath("/users/pedrohubner")
                )
                .forward(forward()
                        .withHost("api.github.com")
                        .withPort(443)
                        .withScheme(HttpForward.Scheme.HTTPS)
                );

        mockMvc.perform(get("/users/{userName}", "pedrohubner"))
                .andExpect(status().isOk());
    }
}
