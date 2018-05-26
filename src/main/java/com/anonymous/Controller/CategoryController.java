package com.anonymous.Controller;

import com.anonymous.Entity.Category;
import com.anonymous.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by akash.mercer on 14-05-2016.
 */


@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody List<Category> findAll(){
        return categoryService.findAll();
    }


}
