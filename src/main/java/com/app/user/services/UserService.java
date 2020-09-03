package com.app.user.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserService {

    public String getGitHubUserWithUsernameInUrl(String userName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/users/";
        String newUrl = url.concat(userName);
        return restTemplate.getForObject(newUrl, String.class);
    }
}
