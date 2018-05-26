package com.anonymous.Service;

import com.anonymous.Beans.GraphBean;
import com.anonymous.Entity.OrderMapping;
import com.anonymous.Entity.User;
import com.anonymous.Repository.OrderMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by akash.mercer on 14-05-2016.
 */
@Service
public class OrderMappingService {

    @Autowired
    private OrderMappingRepository orderMappingRepository;

    @Autowired
    private UserService userService;

    public void save(OrderMapping orderMapping){
        orderMappingRepository.save(orderMapping);
    }

    public GraphBean getTrend(User user, int trendType){
        User retrievedUser = userService.findByEmail(user);

        if (retrievedUser == null) {
            return getEmptyGraphBean();
        }

        List<OrderMapping> orderMappingList = orderMappingRepository.findByUser(retrievedUser);

        HashMap<String, Integer> graphMap = new HashMap<>();

        List<String> graphNameList = new ArrayList<>();
        List<Integer> graphValueList = new ArrayList<>();

        GraphBean graphBean = new GraphBean();

        for (int i = 0; i < orderMappingList.size(); i++) {
            if (orderMappingList.get(i).getSubscription().getDateType() != null) {
                int dateType = orderMappingList.get(i).getSubscription().getDateType().getType();

                if(trendType == 2){
                    if(dateType != 1){
                        continue;
                    }

                    graphBean.setEmail(retrievedUser.getEmail() + " Weekday Trend");
                } else if(trendType == 3){
                    if(dateType != 2){
                        continue;
                    }

                    graphBean.setEmail(retrievedUser.getEmail() + " Weekend Trend");
                } else {
                    graphBean.setEmail(retrievedUser.getEmail() + " General Trend");
                }

                String key = orderMappingList.get(i).getCuisine().getName();

                if(graphMap.containsKey(key)){
                    graphMap.put(orderMappingList.get(i).getCuisine().getName(), graphMap.get(key) + 1);
                } else {
                    graphMap.put(orderMappingList.get(i).getCuisine().getName(), 1);
                }
            }
        }

        for (String key : graphMap.keySet()) {
            graphNameList.add(key);
            graphValueList.add(graphMap.get(key));
        }

        graphBean.setGraphNameList(graphNameList);
        graphBean.setGraphValueList(graphValueList);

        return graphBean;
    }

    private GraphBean getEmptyGraphBean(){
        GraphBean graphBean = new GraphBean();
        graphBean.setGraphNameList(new ArrayList<>());
        graphBean.setGraphValueList(new ArrayList<>());
        graphBean.setEmail("");

        return graphBean;
    }
}
