package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Orator;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * Created by nixit on 12/22/14.
 */
public interface DatabaseService<T> {

    Message create(T object, BindingResult result);
    List<T> listAll();
    Message update(T object, BindingResult result);
    Message delete(int id);
    T get(int id);
}
