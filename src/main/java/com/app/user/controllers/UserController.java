package com.app.user.controllers;

import com.app.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{userName}")
    public String findProductByUserName(@PathVariable String userName) {
        return userService.getGitHubUserWithUsernameInUrl(userName);
    }
}
