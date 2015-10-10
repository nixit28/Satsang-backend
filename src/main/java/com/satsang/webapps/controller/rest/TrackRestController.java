package com.satsang.webapps.controller.rest;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Track;
import com.satsang.webapps.service.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by nixit on 9/19/15.
 */

@RestController
@RequestMapping("/v1")
public class TrackRestController {

    private static final Logger logger = LoggerFactory.getLogger(TrackRestController.class);

    @Autowired
    private DatabaseService<Track> trackDBService;

    @RequestMapping(value = "/tracks", method = RequestMethod.GET)
    public List<Track> listCategories() {
        logger.debug("list Categories");
        return trackDBService.listAll();
    }

    @RequestMapping(value = "/track", method = RequestMethod.POST)
    public Message createTrack(@RequestBody @Valid Track track, BindingResult result) {
        return trackDBService.create(track, result);
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.PUT)
    public Track updateTrack(@PathVariable("id") int trackId, @RequestBody @Valid Track track, BindingResult result) {
        trackDBService.update(track, result);
        return track;
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.DELETE)
    public Message deleteTrack(@PathVariable("id") int trackId) {
        return trackDBService.delete(trackId);
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.GET)
    public Track gettrack(@PathVariable("id") int trackId) {
        return trackDBService.get(trackId);
    }


}
