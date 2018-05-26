package com.anonymous.Controller;

import com.anonymous.Beans.GraphBean;
import com.anonymous.Entity.User;
import com.anonymous.Service.OrderMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by akash.mercer on 14-05-2016.
 */

@RestController
@RequestMapping(value = "/orderMapping")
public class OrderMappingController {

    @Autowired
    OrderMappingService orderMappingService;

    @RequestMapping(value = "/generalTrend", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody GraphBean generalTrend(@RequestBody User user){
        return orderMappingService.getTrend(user, 1);
    }

    @RequestMapping(value = "/weekdayTrend", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody GraphBean weekdayTrend(@RequestBody User user){
        return orderMappingService.getTrend(user, 2);
    }

    @RequestMapping(value = "/weekendTrend", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody GraphBean weekendTrend(@RequestBody User user){
        return orderMappingService.getTrend(user, 3);
    }

}
