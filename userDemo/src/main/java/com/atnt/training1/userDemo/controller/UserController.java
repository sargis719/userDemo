package com.atnt.training1.userDemo.controller;

import com.atnt.training1.userDemo.exception.UserNotFoundException;
import com.atnt.training1.userDemo.model.User;
import com.atnt.training1.userDemo.model.UserResponse;
import com.atnt.training1.userDemo.service.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@ConfigurationProperties
@EnableConfigurationProperties
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("${user-demo.api.version}" + "/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        HttpHeaders responseHeaders = new HttpHeaders();
        userService.save(user);
        return new ResponseEntity<>(user.getUserId() + "Succesfully listed",
               responseHeaders, HttpStatus.OK);

    }
    @GetMapping(value = "${user-demo.api.version}" + "/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable(name = "userId") final Long userId) {
        HttpHeaders responseHeaders = new HttpHeaders();
        if (userService.getUser(userId) == null) {
           return new ResponseEntity<>(new UserNotFoundException("User " + userId + " not found"),
                   responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            final UserResponse retVal = new UserResponse(userService.getUser(userId));
            return new ResponseEntity<>(retVal, responseHeaders, HttpStatus.OK);
        }
    }





}
