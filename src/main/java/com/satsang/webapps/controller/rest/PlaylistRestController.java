package com.satsang.webapps.controller.rest;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Playlist;
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
public class PlaylistRestController {

    private static final Logger logger = LoggerFactory.getLogger(PlaylistRestController.class);

    @Autowired
    private DatabaseService<Playlist> playlistDBService;

    @RequestMapping(value = "/playlists", method = RequestMethod.GET)
    public List<Playlist> listCategories() {
        logger.debug("list Categories");
        return playlistDBService.listAll();
    }

    @RequestMapping(value = "/playlist", method = RequestMethod.POST)
    public Message createPlaylist(@RequestBody @Valid Playlist playlist, BindingResult result) {
        return playlistDBService.create(playlist, result);
    }

    @RequestMapping(value = "/playlist/{id}", method = RequestMethod.PUT)
    public Playlist updatePlaylist(@PathVariable("id") int playlistId, @RequestBody @Valid Playlist playlist, BindingResult result) {
        playlistDBService.update(playlist, result);
        return playlist;
    }

    @RequestMapping(value = "/playlist/{id}", method = RequestMethod.DELETE)
    public Message deletePlaylist(@PathVariable("id") int playlistId) {
        return playlistDBService.delete(playlistId);
    }

    @RequestMapping(value = "/playlist/{id}", method = RequestMethod.GET)
    public Playlist getplaylist(@PathVariable("id") int playlistId) {
        return playlistDBService.get(playlistId);
    }


}
