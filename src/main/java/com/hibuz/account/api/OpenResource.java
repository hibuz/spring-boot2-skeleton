package com.hibuz.account.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/open")
public class OpenResource {

    /**
     * Gets a list of all roles.
     * @return a string list of all roles.
     */
    @GetMapping("/hello")
    public String hello(@Parameter(example = "John") String name) {
        return "Hi " + name;
    }

}
