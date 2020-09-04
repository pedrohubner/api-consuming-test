package com.app.mockserver;

import org.mockserver.mock.action.ExpectationResponseCallback;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.mockserver.model.HttpResponse.response;

public class CallbackClass implements ExpectationResponseCallback {

    @Override
    public HttpResponse handle(HttpRequest httpRequest) {
        return response()
                .withStatusCode(200)
                .withBody("{\"login\":\"pedrohubner\",\"id\":54464720,\"node_id\":\"MDQ6VXNlcjU0NDY0NzIw\",\"avatar_url\":\"https://avatars1.githubusercontent.com/u/54464720?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/pedrohubner\",\"html_url\":\"https://github.com/pedrohubner\",\"followers_url\":\"https://api.github.com/users/pedrohubner/followers\",\"following_url\":\"https://api.github.com/users/pedrohubner/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/pedrohubner/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/pedrohubner/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/pedrohubner/subscriptions\",\"organizations_url\":\"https://api.github.com/users/pedrohubner/orgs\",\"repos_url\":\"https://api.github.com/users/pedrohubner/repos\",\"events_url\":\"https://api.github.com/users/pedrohubner/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/pedrohubner/received_events\",\"type\":\"User\",\"site_admin\":false,\"name\":\"Pedro Hübner\",\"company\":null,\"blog\":\"\",\"location\":\"Rio Grande do Sul, Brasil\",\"email\":null,\"hireable\":null,\"bio\":null,\"twitter_username\":null,\"public_repos\":6,\"public_gists\":1,\"followers\":8,\"following\":9,\"created_at\":\"2019-08-24T05:21:12Z\",\"updated_at\":\"2020-09-03T02:39:30Z\"}"
                );
    }
}
