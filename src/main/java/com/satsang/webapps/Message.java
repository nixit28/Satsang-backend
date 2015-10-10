package com.satsang.webapps;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by nixit on 12/22/14.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Message<T> {
    Integer id;
    private boolean success;
    private List<String> errors;
    private String message;
    private T object;

    public Message(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
