package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Orator;
import com.satsang.webapps.repositories.OratorRepository;
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
public class OratorDatabaseServiceImpl implements DatabaseService<Orator> {

    @Autowired
    private OratorRepository oratorRepository;

    private static final Logger logger = LoggerFactory.getLogger(OratorDatabaseServiceImpl.class);

    @Override
    public Message create(Orator object, BindingResult result) {
        if(result.hasErrors()){
            Message oratorMessage = new Message("There is error in inserting the orator", false);
            List<String> errorOrator = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorOrator.add(error.getDefaultMessage());
            }
            oratorMessage.setErrors(errorOrator);
            return oratorMessage;
        }else {
            object = oratorRepository.save(object);
            Message oratorMessage = new Message("Orator Save Successfully", true);
            oratorMessage.setId(object.getIdOrator());
            return oratorMessage;
        }

    }

    @Override
    public List<Orator> listAll() {
        logger.debug("getting list of orators");
        List<Orator> orators = oratorRepository.findAll();
        return orators;
    }

    @Override
    public Orator get(int id) {
        return oratorRepository.findOne(id);
    }

    @Override
    public Message update(Orator object, BindingResult result) {
        if(result.hasErrors()){
            Message oratorMessage = new Message("There is error in inserting the orator", false);
            List<String> errorOrator = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorOrator.add(error.getDefaultMessage());
            }
            oratorMessage.setErrors(errorOrator);
            return oratorMessage;
        }else {
            oratorRepository.save(object);
            Message oratorMessage = new Message("Orator save successfully", true);
            oratorMessage.setId(object.getIdOrator());
            return oratorMessage;
        }
    }

    @Override
    public Message delete(int id) {
        oratorRepository.delete(id);
        Message message = new Message("Object deleted successfully", true);
        return message;
    }
}
