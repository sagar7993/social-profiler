package com.anonymous.Beans;

/**
 * Created by akash.mercer on 15-05-2016.
 */
public class RestaurantRequestBean {

    private String restaurantNames;

    private String timestamp;

    private String email;

    public RestaurantRequestBean(){

    }

    public String getRestaurantNames() {
        return restaurantNames;
    }

    public void setRestaurantNames(String restaurantNames) {
        this.restaurantNames = restaurantNames;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
