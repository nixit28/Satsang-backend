package com.satsang.webapps.controller.rest;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Granth;
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
public class GranthRestController {

    private static final Logger logger = LoggerFactory.getLogger(GranthRestController.class);

    @Autowired
    private DatabaseService<Granth> granthDBService;

    @RequestMapping(value = "/granths", method = RequestMethod.GET)
    public List<Granth> listGranths() {
        logger.debug("list Granths");
        return granthDBService.listAll();
    }

    @RequestMapping(value = "/granth", method = RequestMethod.POST)
    public Message createGranth(@RequestBody @Valid Granth granth, BindingResult result) {
        return granthDBService.create(granth, result);
    }

    @RequestMapping(value = "/granth/{id}", method = RequestMethod.PUT)
    public Granth updateGranth(@PathVariable("id") int orderId, @RequestBody @Valid Granth granth, BindingResult result) {
        granthDBService.update(granth, result);
        return granth;
    }

    @RequestMapping(value = "/granth/{id}", method = RequestMethod.DELETE)
    public Message deleteGranth(@PathVariable("id") int granthId) {
        return granthDBService.delete(granthId);
    }

    @RequestMapping(value = "/granth/{id}", method = RequestMethod.GET)
    public Granth getGranth(@PathVariable("id") int granthId) {
        return granthDBService.get(granthId);
    }

}