package com.anonymous.Controller;

import com.anonymous.Beans.RestaurantRequestBean;
import com.anonymous.Entity.Subscription;
import com.anonymous.Entity.User;
import com.anonymous.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by akash.mercer on 14-05-2016.
 */

@RestController
@RequestMapping(value = "/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public void save(@RequestBody Subscription subscription){
        subscriptionService.save(subscription);
    }

    @RequestMapping(value = "/findByUser", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody List<Subscription> findByUser(@RequestBody User user){
        return subscriptionService.findByUser(user);
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST, consumes = "application/json")
    public void placeOrder(@RequestBody RestaurantRequestBean restaurantRequestBean){
        subscriptionService.placeOrder(restaurantRequestBean);
    }

}
