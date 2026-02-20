package com.hibuz.account.api;

import com.hibuz.account.application.UserService;
import com.hibuz.account.global.common.Constants;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing the current user's account.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api")
@Tag(name="user-resource", description = "username=" + Constants.USER + ", password=" + Constants.PASSWORD)
public class UserResource {

    private final UserService userService;

    /**
     * Gets a list of all roles.
     * @return a string list of all roles.
     */
    @GetMapping("/authorities")
    public List<String> getAuthorities() {
        return userService.getAuthorities();
    }

}
