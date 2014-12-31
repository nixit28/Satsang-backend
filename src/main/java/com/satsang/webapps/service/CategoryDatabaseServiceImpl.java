package com.satsang.webapps.service;

import com.satsang.webapps.Message;
import com.satsang.webapps.entity.Category;
import com.satsang.webapps.entity.Category;
import com.satsang.webapps.repositories.CategoryRepository;
import com.satsang.webapps.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixit on 12/22/14.
 */
public class CategoryDatabaseServiceImpl implements DatabaseService<Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(CategoryDatabaseServiceImpl.class);

    @Override
    public Message create(Category object, BindingResult result) {
        if(result.hasErrors()){
            Message categoryMessage = new Message("There is error in inserting the category", false);
            List<String> errorCategory = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorCategory.add(error.getDefaultMessage());
            }
            categoryMessage.setErrors(errorCategory);
            return categoryMessage;
        }else {
            object = categoryRepository.save(object);
            Message categoryMessage = new Message("Category Save Successfully", true);
            categoryMessage.setId(object.getIdCategory());
            return categoryMessage;
        }

    }

    @Override
    public List<Category> listAll() {
        logger.debug("getting list of categorys");
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category get(int id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Message update(Category object, BindingResult result) {
        if(result.hasErrors()){
            Message categoryMessage = new Message("There is error in inserting the category", false);
            List<String> errorCategory = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errorCategory.add(error.getDefaultMessage());
            }
            categoryMessage.setErrors(errorCategory);
            return categoryMessage;
        }else {
            categoryRepository.save(object);
            Message categoryMessage = new Message("Category save successfully", true);
            categoryMessage.setId(object.getIdCategory());
            return categoryMessage;
        }
    }

    @Override
    public Message delete(int id) {
        categoryRepository.delete(id);
        Message message = new Message("Object deleted successfully", true);
        return message;
    }
}
