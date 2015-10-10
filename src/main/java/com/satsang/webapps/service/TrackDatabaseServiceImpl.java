package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Track;
import com.satsang.webapps.repositories.TrackRepository;
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
public class TrackDatabaseServiceImpl implements DatabaseService<Track> {

    @Autowired
    private TrackRepository trackRepository;

    private static final Logger logger = LoggerFactory.getLogger(TrackDatabaseServiceImpl.class);

    @Override
    public Message create(Track object, BindingResult result) {
        if(result.hasErrors()){
            Message trackMessage = new Message("There is error in inserting the track", false);
            List<String> errorTrack = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorTrack.add(error.getDefaultMessage());
            }
            trackMessage.setErrors(errorTrack);
            return trackMessage;
        }else {
            object = trackRepository.save(object);
            Message trackMessage = new Message("Track Save Successfully", true);
            trackMessage.setId(object.getIdTrack());
            return trackMessage;
        }

    }

    @Override
    public List<Track> listAll() {
        logger.debug("getting list of tracks");
        List<Track> tracks = trackRepository.findAll();
        return tracks;
    }

    @Override
    public Track get(int id) {
        return trackRepository.findOne(id);
    }

    @Override
    public Message update(Track object, BindingResult result) {
        if(result.hasErrors()){
            Message trackMessage = new Message("There is error in inserting the track", false);
            List<String> errorTrack = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorTrack.add(error.getDefaultMessage());
            }
            trackMessage.setErrors(errorTrack);
            return trackMessage;
        }else {
            trackRepository.save(object);
            Message trackMessage = new Message("Track save successfully", true);
            trackMessage.setId(object.getIdTrack());
            return trackMessage;
        }
    }

    @Override
    public Message delete(int id) {
        trackRepository.delete(id);
        Message message = new Message("Object deleted successfully", true);
        return message;
    }
}
