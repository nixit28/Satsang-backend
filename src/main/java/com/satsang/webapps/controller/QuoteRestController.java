package com.satsang.webapps.controller;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Quote;
import com.satsang.webapps.service.QuoteDatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class QuoteRestController {

    private static final Logger logger = LoggerFactory.getLogger(QuoteRestController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

    @Autowired
    private QuoteDatabaseService  quoteDBService;

    @RequestMapping(value = "/quotes", method = RequestMethod.GET)
    public List<Quote> listQuotes() {
        logger.debug("list Quotes");
        return quoteDBService.listAll();
    }

    @RequestMapping(value = "/quote", method = RequestMethod.POST)
    public Message createQuote(@RequestBody @Valid Quote quote, BindingResult result) {
        return quoteDBService.create(quote, result);
    }

    @RequestMapping(value = "/quote/{id}", method = RequestMethod.PUT)
    public Quote updateQuote(@PathVariable("id") int orderId, @RequestBody @Valid Quote quote, BindingResult result) {
        quoteDBService.update(quote, result);
        return quote;
    }

    @RequestMapping(value = "/quote/{id}", method = RequestMethod.DELETE)
    public Message deleteQuote(@PathVariable("id") int quoteId) {
        return quoteDBService.delete(quoteId);
    }

    @RequestMapping(value = "/quote/{id}", method = RequestMethod.GET)
    public Quote getQuote(@PathVariable("id") int quoteId) {
        return quoteDBService.get(quoteId);
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public Quote findByDate(@RequestParam("date") Date quotePublishDate) {
        return quoteDBService.find(quotePublishDate);
    }


    @RequestMapping(value = "/quote/{id}", method = RequestMethod.POST)
    public Quote peakQuote(@PathVariable("id") int quoteId) {
        return quoteDBService.get(quoteId);
    }

}