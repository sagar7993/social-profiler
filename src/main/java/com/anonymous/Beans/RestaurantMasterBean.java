package com.anonymous.Beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash.mercer on 15-05-2016.
 */
public class RestaurantMasterBean {

    private List<RestaurantUselessBean> restaurants = new ArrayList<>();

    public RestaurantMasterBean(){

    }

    public List<RestaurantUselessBean> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantUselessBean> restaurants) {
        this.restaurants = restaurants;
    }
}
