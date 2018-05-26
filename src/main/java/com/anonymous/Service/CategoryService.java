package com.anonymous.Service;

import com.anonymous.Entity.Category;
import com.anonymous.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by akash.mercer on 14-05-2016.
 */


@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return (List<Category>) categoryRepository.findAll();
    }


}
