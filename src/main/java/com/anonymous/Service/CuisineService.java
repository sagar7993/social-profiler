package com.anonymous.Service;

import com.anonymous.Entity.Cuisine;
import com.anonymous.Repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by akash.mercer on 14-05-2016.
 */
@Service
public class CuisineService {

    @Autowired
    private CuisineRepository cuisineRepository;

    public List<Cuisine> findAll(){
        return (List<Cuisine>) cuisineRepository.findAll();
    }

    public Cuisine save(Cuisine cuisine){
        Cuisine retrievedCuisine = cuisineRepository.findByName(cuisine.getName());

        if (retrievedCuisine == null) {
            return cuisineRepository.save(cuisine);
        }

        return retrievedCuisine;
    }

    public Cuisine findById(Long cuisineId){
        return cuisineRepository.findById(cuisineId);
    }
}
