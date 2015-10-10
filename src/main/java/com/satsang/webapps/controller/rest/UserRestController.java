package com.satsang.webapps.controller.rest;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by nixit on 9/21/15.
 */

@RestController
@RequestMapping("/v1")
public class UserRestController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Message login(@RequestBody @Valid User user, BindingResult result) {

        return new Message("Login Failed", false);
    }

}
