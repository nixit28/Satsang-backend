package com.satsang.webapps.controller;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Category;
import com.satsang.webapps.service.DatabaseService;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by nixit on 9/25/15.
 */

@Controller
@RequestMapping("/category")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private DatabaseService<Category> categoryDBService;

    @RequestMapping(method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("title", "Category");
        List<Category> categories = categoryDBService.listAll();
        model.addAttribute("categories", categories);
        model.addAttribute("newCategory", new Category());
        return "category";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTrack(Model model, Category category, BindingResult result) {

        List<Category> categories = categoryDBService.listAll();
        Message value = categoryDBService.create(category, result);

        model.addAttribute("title", "Category");
        model.addAttribute("categories", categories);
        model.addAttribute("message", value);
        model.addAttribute("newCategory", new Category());
        return "redirect:/category";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCategory(Model model, @PathVariable("id") int categoryId){
        Message value = categoryDBService.delete(categoryId);
        List<Category> categories = categoryDBService.listAll();
        model.addAttribute("title", "Category");
        model.addAttribute("categories", categories);
        model.addAttribute("message", value);
        model.addAttribute("newCategory", new Category());
        return "category";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getCategory(Model model, @PathVariable("id") int categoryId){
        List<Category> categories = categoryDBService.listAll();
        Category value = categoryDBService.get(categoryId);

        model.addAttribute("title", "Category");
        model.addAttribute("categories", categories);
        model.addAttribute("message", value);
        model.addAttribute("newCategory", new Category());
        return "redirect:/category";
    }


}
