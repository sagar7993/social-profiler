package com.anonymous.Controller;

import com.anonymous.Entity.Cuisine;
import com.anonymous.Service.CuisineService;
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
@RequestMapping(value = "/cuisine")
public class CuisineController {

    @Autowired
    CuisineService cuisineService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody List<Cuisine> findAll(){
        return cuisineService.findAll();
    }

}
