package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Playlist;
import com.satsang.webapps.repositories.PlaylistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixit on 12/22/14.
 */
public class PlaylistDatabaseServiceImpl implements DatabaseService<Playlist> {

    @Autowired
    private PlaylistRepository playlistRepository;

    private static final Logger logger = LoggerFactory.getLogger(PlaylistDatabaseServiceImpl.class);

    @Override
    public Message create(Playlist object, BindingResult result) {
        if(result.hasErrors()){
            Message playlistMessage = new Message("There is error in inserting the playlist", false);
            List<String> errorPlaylist = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorPlaylist.add(error.getDefaultMessage());
            }
            playlistMessage.setErrors(errorPlaylist);
            return playlistMessage;
        }else {
            object = playlistRepository.save(object);
            Message playlistMessage = new Message("Playlist Save Successfully", true);
            playlistMessage.setId(object.getIdPlaylist());
            return playlistMessage;
        }

    }

    @Override
    public List<Playlist> listAll() {
        logger.debug("getting list of playlists");
        List<Playlist> playlists = playlistRepository.findAll();
        return playlists;
    }

    @Override
    public Playlist get(int id) {
        return playlistRepository.findOne(id);
    }

    @Override
    public Message update(Playlist object, BindingResult result) {
        if(result.hasErrors()){
            Message playlistMessage = new Message("There is error in inserting the playlist", false);
            List<String> errorPlaylist = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorPlaylist.add(error.getDefaultMessage());
            }
            playlistMessage.setErrors(errorPlaylist);
            return playlistMessage;
        }else {
            playlistRepository.save(object);
            Message playlistMessage = new Message("Playlist save successfully", true);
            playlistMessage.setId(object.getIdPlaylist());
            return playlistMessage;
        }
    }

    @Override
    public Message delete(int id) {
        playlistRepository.delete(id);
        Message message = new Message("Object deleted successfully", true);
        return message;
    }
}
