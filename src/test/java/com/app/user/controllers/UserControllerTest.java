package com.app.user.controllers;

import com.app.facade.AppFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AppFacade appFacade;

    @Test
    public void should_Return_GithubUserInfo_When_Find_byUserName() throws Exception {
        when(appFacade.getGitHubUserByUsernameInUrl("pedrohubner")).thenReturn("{\"login\":\"pedrohubner\",\"id\":54464720,\"node_id\":\"MDQ6VXNlcjU0NDY0NzIw\",\"avatar_url\":\"https://avatars1.githubusercontent.com/u/54464720?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/pedrohubner\",\"html_url\":\"https://github.com/pedrohubner\",\"followers_url\":\"https://api.github.com/users/pedrohubner/followers\",\"following_url\":\"https://api.github.com/users/pedrohubner/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/pedrohubner/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/pedrohubner/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/pedrohubner/subscriptions\",\"organizations_url\":\"https://api.github.com/users/pedrohubner/orgs\",\"repos_url\":\"https://api.github.com/users/pedrohubner/repos\",\"events_url\":\"https://api.github.com/users/pedrohubner/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/pedrohubner/received_events\",\"type\":\"User\",\"site_admin\":false,\"name\":\"Pedro Hübner\",\"company\":null,\"blog\":\"\",\"location\":\"Rio Grande do Sul, Brasil\",\"email\":null,\"hireable\":null,\"bio\":null,\"twitter_username\":null,\"public_repos\":6,\"public_gists\":1,\"followers\":8,\"following\":9,\"created_at\":\"2019-08-24T05:21:12Z\",\"updated_at\":\"2020-09-03T02:39:30Z\"}");

        mockMvc.perform(get("/users/{userName}", "pedrohubner"))
                .andExpect(content().string("{\"login\":\"pedrohubner\",\"id\":54464720,\"node_id\":\"MDQ6VXNlcjU0NDY0NzIw\",\"avatar_url\":\"https://avatars1.githubusercontent.com/u/54464720?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/pedrohubner\",\"html_url\":\"https://github.com/pedrohubner\",\"followers_url\":\"https://api.github.com/users/pedrohubner/followers\",\"following_url\":\"https://api.github.com/users/pedrohubner/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/pedrohubner/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/pedrohubner/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/pedrohubner/subscriptions\",\"organizations_url\":\"https://api.github.com/users/pedrohubner/orgs\",\"repos_url\":\"https://api.github.com/users/pedrohubner/repos\",\"events_url\":\"https://api.github.com/users/pedrohubner/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/pedrohubner/received_events\",\"type\":\"User\",\"site_admin\":false,\"name\":\"Pedro Hübner\",\"company\":null,\"blog\":\"\",\"location\":\"Rio Grande do Sul, Brasil\",\"email\":null,\"hireable\":null,\"bio\":null,\"twitter_username\":null,\"public_repos\":6,\"public_gists\":1,\"followers\":8,\"following\":9,\"created_at\":\"2019-08-24T05:21:12Z\",\"updated_at\":\"2020-09-03T02:39:30Z\"}"))
                .andExpect(status().isOk());
    }
}