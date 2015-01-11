package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Orator;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * Created by nixit on 12/22/14.
 */
public interface DatabaseService<T> {

    public Message create(T object, BindingResult result);
    public List<T> listAll();
    public Message update(T object, BindingResult result);
    public Message delete(int id);
    public T get(int id);
}
