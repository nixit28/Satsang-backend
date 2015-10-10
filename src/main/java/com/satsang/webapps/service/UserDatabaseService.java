package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.User;
import org.springframework.validation.BindingResult;

/**
 * Created by nixit on 9/21/15.
 */
public interface UserDatabaseService extends DatabaseService<User> {

    Message login(User user, BindingResult result);
}
