package com.app.facade;

import com.app.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppFacade {

    private final UserService userService;

    public String getGitHubUserWithUsernameInUrl(String userName) {
        return userService.getGitHubUserWithUsernameInUrl(userName);
    }
}
