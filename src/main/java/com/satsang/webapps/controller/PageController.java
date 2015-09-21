package com.satsang.webapps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nixit on 1/10/15.
 */

@Controller
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("message", "Hello, How are you");
        return "hello";
    }
}
