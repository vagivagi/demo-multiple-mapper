package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("jpa/{name}")
    List<User> getAndAddUsingJpa(@PathVariable String name) {
        return this.userService.addAndFindAllUsingJpa(name);
    }

    @GetMapping("mybatis/{name}")
    List<User> getAndAddUsingMyBatis(@PathVariable String name) {
        return this.userService.addAndFindAllUsingMyBatis(name);
    }

    @GetMapping("multiple/{name}")
    List<User> getAndAddUsingMultiple(@PathVariable String name) {
        return this.userService.addAndFindAllUsingMultipleMapper(name);
    }
}
