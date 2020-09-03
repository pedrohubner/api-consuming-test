package com.app.user.controllers;

import com.app.facade.AppFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final AppFacade appFacade;

    @GetMapping(value = "/{userName}")
    public String findProductByUserName(@PathVariable String userName) {
        return appFacade.getGitHubUserWithUsernameInUrl(userName);
    }
}
