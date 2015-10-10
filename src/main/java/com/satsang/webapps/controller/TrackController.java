package com.satsang.webapps.controller;

import com.satsang.webapps.entity.Category;
import com.satsang.webapps.entity.Track;
import com.satsang.webapps.service.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by nixit on 9/25/15.
 */

@Controller
@RequestMapping("/track")
public class TrackController {

    private static final Logger logger = LoggerFactory.getLogger(TrackController.class);
    @Autowired
    private DatabaseService<Category> categoryDBService;
    private DatabaseService<Track> trackDBService;


    @RequestMapping(method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("title", "Track");
        List<Category> categories = categoryDBService.listAll();
        model.addAttribute("categories", categories);
        model.addAttribute("newTrack", new Track());
        return "track";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTrack(Model model, Track track) {
        model.addAttribute("title", "Track");
        return "track";
    }


}
