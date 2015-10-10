package com.satsang.webapps.controller.rest;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Orator;
import com.satsang.webapps.service.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class OratorRestController {

    private static final Logger logger = LoggerFactory.getLogger(OratorRestController.class);

    @Autowired
    private DatabaseService<Orator> oratorDBService;

    @RequestMapping(value = "/orators", method = RequestMethod.GET)
    public List<Orator> listOrators() {
        logger.debug("list Orators");
        return oratorDBService.listAll();
    }

    @RequestMapping(value = "/orator", method = RequestMethod.POST)
    public Message createOrator(@RequestBody @Valid Orator orator, BindingResult result) {
        return oratorDBService.create(orator, result);
    }

    @RequestMapping(value = "/orator/{id}", method = RequestMethod.PUT)
    public Orator updateOrator(@PathVariable("id") int orderId, @RequestBody @Valid Orator orator, BindingResult result) {
        oratorDBService.update(orator, result);
        return orator;
    }

    @RequestMapping(value = "/orator/{id}", method = RequestMethod.DELETE)
    public Message deleteOrator(@PathVariable("id") int oratorId) {
        return oratorDBService.delete(oratorId);
    }

    @RequestMapping(value = "/orator/{id}", method = RequestMethod.GET)
    public Orator getOrator(@PathVariable("id") int oratorId) {
        return oratorDBService.get(oratorId);
    }

}