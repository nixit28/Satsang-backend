package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Category;
import com.satsang.webapps.entity.Granth;
import com.satsang.webapps.repositories.GranthRepository;
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
public class GranthDatabaseServiceImpl implements DatabaseService<Granth> {

    private static final Logger logger = LoggerFactory.getLogger(GranthDatabaseServiceImpl.class);

    @Autowired
    private GranthRepository granthRepository;

    @Override
    public Message create(Granth object, BindingResult result) {
        if (result.hasErrors()) {
            Message granthMessage = new Message("There is error in inserting the granth", false);
            List<String> errorGranth = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorGranth.add(error.getDefaultMessage());
            }
            granthMessage.setErrors(errorGranth);
            return granthMessage;
        } else {
            object = granthRepository.save(object);
            Message granthMessage = new Message("Granth Save Successfully", true);
            granthMessage.setId(object.getIdGranth());
            return granthMessage;
        }
    }

    @Override
    public List<Granth> listAll() {
        logger.debug("getting list of granths");
        List<Granth> granths = granthRepository.findAll();
        return granths;
    }

    @Override
    public Granth get(int id) {
        return granthRepository.findOne(id);
    }

    @Override
    public Message update(Granth object, BindingResult result) {
        if (result.hasErrors()) {
            Message granthMessage = new Message("There is error in inserting the granth", false);
            List<String> errorGranth = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorGranth.add(error.getDefaultMessage());
            }
            granthMessage.setErrors(errorGranth);
            return granthMessage;
        } else {
            granthRepository.save(object);
            Message granthMessage = new Message("Granth save successfully", true);
            granthMessage.setId(object.getIdGranth());
            return granthMessage;
        }
    }

    @Override
    public Message delete(int id) {
        granthRepository.delete(id);
        Message message = new Message("Object deleted successfully", true);
        return message;
    }
}
