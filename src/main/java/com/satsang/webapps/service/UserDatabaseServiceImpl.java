package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.User;
import com.satsang.webapps.repositories.QuoteRepository;
import com.satsang.webapps.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixit on 9/21/15.
 */
public class UserDatabaseServiceImpl implements UserDatabaseService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(QuoteDatabaseServiceImpl.class);


    @Override
    public Message login(User user, BindingResult result) {
        if (result.hasErrors()) {
            Message errorMessage = new Message("There is error while login", false);
            List<String> errorQuotes = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorQuotes.add(error.getDefaultMessage());
            }
            errorMessage.setErrors(errorQuotes);
            return errorMessage;
        } else {
            User logedInuser = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
            if(logedInuser==null){
                Message errorMessage = new Message("Login failed", false);
                return errorMessage;
            }else{
                Message message = new Message("Login success", false);

                return message;
            }
        }
    }

    @Override
    public Message create(User object, BindingResult result) {
        return null;
    }

    @Override
    public List<User> listAll() {
        return null;
    }

    @Override
    public Message update(User object, BindingResult result) {
        return null;
    }

    @Override
    public Message delete(int id) {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }
}
