package com.anonymous.Beans;

import com.anonymous.Entity.Category;
import com.anonymous.Entity.Cuisine;

/**
 * Created by akash.mercer on 14-05-2016.
 */
public class OrderMappingBean {
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private Category category;

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    private Cuisine cuisine;
}
