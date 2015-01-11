package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Quote;
import com.satsang.webapps.repositories.QuoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nixit on 12/22/14.
 */
public class QuoteDatabaseServiceImpl implements QuoteDatabaseService {

    @Autowired
    private QuoteRepository quoteRepository;

    private static final Logger logger = LoggerFactory.getLogger(QuoteDatabaseServiceImpl.class);

    @Override
    public Message create(Quote object, BindingResult result) {
        if(result.hasErrors()){
            Message quotesMessage = new Message("There is error in inserting the quotes", false);
            List<String> errorQuotes = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorQuotes.add(error.getDefaultMessage());
            }
            quotesMessage.setErrors(errorQuotes);
            return quotesMessage;
        }else {
            object = quoteRepository.save(object);
            Message quotesMessage = new Message("Quote Save Successfully", true);
            quotesMessage.setId(object.getIdQuotes());
            return quotesMessage;
        }

    }

    @Override
    public List<Quote> listAll() {
        logger.debug("getting list of quotes");
        List<Quote> list = quoteRepository.findAll();
        return list;
    }

    @Override
    public Quote get(int id) {
        return quoteRepository.findOne(id);
    }

    @Override
    public Message update(Quote object, BindingResult result) {
        if(result.hasErrors()){
            Message quotesMessage = new Message("There is error in inserting the quotes", false);
            List<String> errorQuotes = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorQuotes.add(error.getDefaultMessage());
            }
            quotesMessage.setErrors(errorQuotes);
            return quotesMessage;
        }else {
            quoteRepository.save(object);
            Message quotesMessage = new Message("Quote save successfully", true);
            quotesMessage.setId(object.getIdQuotes());
            return quotesMessage;
        }
    }

    @Override
    public Message delete(int id) {
        quoteRepository.delete(id);
        Message message = new Message("Object deleted successfully", true);
        return message;
    }

    @Override
    public Quote find(Date date) {
        return quoteRepository.findByDatePublish(date);
    }

    @Override
    public List<Quote> findAllGrater(Date date) {
        return quoteRepository.findByDatePublishGreaterThanEqual(date);
    }

    @Override
    public List<Quote> findAllLess(Date date) {
        return quoteRepository.findByDatePublishLessThan(date);
    }
}
