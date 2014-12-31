package com.satsang.webapps.controller;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Category;
import com.satsang.webapps.entity.Category;
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
public class CategoryRestController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryRestController.class);

    @Autowired
    private DatabaseService<Category> categoryDBService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> listCategories() {
        logger.debug("list Categories");
        return categoryDBService.listAll();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Message createCategory(@RequestBody @Valid Category category, BindingResult result) {
        return categoryDBService.create(category, result);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public Category updateCategory(@PathVariable("id") int orderId, @RequestBody @Valid Category category, BindingResult result) {
        categoryDBService.update(category, result);
        return category;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public Message deleteCategory(@PathVariable("id") int categoryId) {
        return categoryDBService.delete(categoryId);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public Category getcategory(@PathVariable("id") int categoryId) {
        return categoryDBService.get(categoryId);
    }

}