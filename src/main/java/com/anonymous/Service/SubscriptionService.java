package com.anonymous.Service;

import com.anonymous.Beans.RestaurantMasterBean;
import com.anonymous.Beans.RestaurantRequestBean;
import com.anonymous.Entity.*;
import com.anonymous.Repository.SubscriptionRepository;
import com.anonymous.Utils.DateOperation;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by akash.mercer on 14-05-2016.
 */

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CuisineService cuisineService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private OrderMappingService orderMappingService;

    @Autowired
    private DateTypeService dateTypeService;

    public void save(Subscription subscription){
        User retrievedUser = userService.save(subscription.getUser());
        subscription.setUser(retrievedUser);

        Partner retrievedPartner = partnerService.save(subscription.getPartner());
        subscription.setPartner(retrievedPartner);

        DateType dateType = dateTypeService.findByType(DateOperation.getDateTypeFromLong(subscription.getDate().getTime()));
        subscription.setDateType(dateType);

        Subscription retrievedSubscription =  subscriptionRepository.save(subscription);

        for (int i = 0; i < subscription.getCuisineIdList().size();i++){
            Cuisine retrievedCuisine = cuisineService.findById(subscription.getCuisineIdList().get(i));

            OrderMapping orderMapping = new OrderMapping();
            orderMapping.setSubscription(retrievedSubscription);
            orderMapping.setCuisine(retrievedCuisine);

            orderMappingService.save(orderMapping);
        }
    }

    public List<Subscription> findByUser(User user){
        return subscriptionRepository.findByUser(user.getId());
    }

    public void placeOrder(RestaurantRequestBean restaurantRequestBean){
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> httpMessageConverterList = new ArrayList<>();
        httpMessageConverterList.add(new FormHttpMessageConverter());
        httpMessageConverterList.add(new StringHttpMessageConverter());
        httpMessageConverterList.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(httpMessageConverterList);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("user-key", "878ef012fb9eed866370e6867bc884ff");

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        //Explode Restaurant array
        String[] restaurantArray = restaurantRequestBean.getRestaurantNames().split(",");

        //Explode Restaurant array
        String[] dateArray = restaurantRequestBean.getTimestamp().split(",");

        for (int i = 0; i < restaurantArray.length; i++) {
            ResponseEntity<String> response = restTemplate.exchange("https://developers.zomato.com/api/v2.1/search?q={query}", HttpMethod.POST, entity, String.class, restaurantArray[i].trim());

            if(response.getStatusCode() == HttpStatus.OK){
                RestaurantMasterBean restaurantMasterBean = new Gson().fromJson(response.getBody(), RestaurantMasterBean.class);
                for (int j = 0; j < restaurantMasterBean.getRestaurants().size(); j++) {
                    String cuisines = restaurantMasterBean.getRestaurants().get(j).getRestaurant().getCuisines();

                    if(cuisines != null && !cuisines.isEmpty()){
                        //Explode Cuisine array
                        String[] cuisineArray = cuisines.split(",");

                        List<Cuisine> cuisineList = new ArrayList<>();

                        //Insert all the Cuisines in Database (If not exist)
                        for (int k = 0; k < cuisineArray.length; k++) {
                            Cuisine cuisine = new Cuisine();
                            cuisine.setName(cuisineArray[k].trim());
                            cuisineList.add(cuisineService.save(cuisine));
                        }

                        //Create new Subscription
                        Subscription subscription = new Subscription();

                        //Create empty User
                        User user = new User();
                        user.setEmail(restaurantRequestBean.getEmail());

                        //Retrieve user on the basis of whether it exists in Database
                        User retrievedUser = userService.save(user);
                        subscription.setUser(retrievedUser);

                        DateType dateType = dateTypeService.findByType(DateOperation.getDateTypeFromLong(Long.valueOf(dateArray[i])));
                        subscription.setDateType(dateType);

                        subscription.setDate(DateOperation.getDateFromLong(Long.valueOf(dateArray[i])));

                        //Save Subscription
                        Subscription retrievedSubscription = subscriptionRepository.save(subscription);

                        //Insert all the Order and Cuisine Mappings (If not exist)
                        for (int z = 0; z < cuisineList.size(); z++) {
                            OrderMapping orderMapping = new OrderMapping();
                            orderMapping.setSubscription(retrievedSubscription);
                            orderMapping.setCuisine(cuisineList.get(z));
                            orderMappingService.save(orderMapping);
                        }

                        break;
                    }
                }
            }
        }
    }
}
