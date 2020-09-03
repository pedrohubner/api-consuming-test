package com.app.user.services;

import com.app.config.ApplicationPropertiesLoader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Service
@AllArgsConstructor
public class UserService {

    private final RestTemplate restTemplate;

    private final ApplicationPropertiesLoader loader;

    public String getGitHubUserWithUsernameInUrl(String userName) {
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(loader.getUrl()));
        return restTemplate.getForObject("/users/{userName}", String.class, userName);
    }
}
