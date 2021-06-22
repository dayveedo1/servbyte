package com.david.ServByte.service;

import com.david.ServByte.model.City;
import com.david.ServByte.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AppService {

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private MealRepository mealRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ServiceProviderRepository serviceProviderRepo;

    @Autowired
    private UserRepository userRepo;


    public CityRepository getCityRepo() {
        return cityRepo;
    }

    public void setCityRepo(CityRepository cityRepo) {
        this.cityRepo = cityRepo;
    }

    public MealRepository getMealRepo() {
        return mealRepo;
    }

    public void setMealRepo(MealRepository mealRepo) {
        this.mealRepo = mealRepo;
    }

    public OrderRepository getOrderRepo() {
        return orderRepo;
    }

    public void setOrderRepo(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public ServiceProviderRepository getServiceProviderRepo() {
        return serviceProviderRepo;
    }

    public void setServiceProviderRepo(ServiceProviderRepository serviceProviderRepo) {
        this.serviceProviderRepo = serviceProviderRepo;
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //<editor-fold desc = "City"

    //</editor-fold


}
