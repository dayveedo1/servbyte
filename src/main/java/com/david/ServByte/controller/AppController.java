package com.david.ServByte.controller;

import com.david.ServByte.constants.ApiResponse;
import com.david.ServByte.constants.CustomMessages;
import com.david.ServByte.exception.RecordNotFoundException;
import com.david.ServByte.model.City;
import com.david.ServByte.model.ServiceProvider;
import com.david.ServByte.service.AppService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.cldr.ts.CurrencyNames_ts;

import javax.xml.ws.Response;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class AppController {

    private static String NotFoundMessage = "Record Not Found: ";
    @Autowired
    private AppService service;

    //<editor-fold desc = "City"
    @ApiOperation("To save a city record")
    @PostMapping(value= "/city")
    public ResponseEntity<?> saveCity(@RequestBody City city){
        City newCity = service.getCityRepo().save(city);
        return ResponseEntity.ok(new ApiResponse<>(CustomMessages.Success, newCity));
    }

    @ApiOperation("To return list of all cities")
    @GetMapping(value = "/city")
    public List<City> getAllCities(){
        return service.getCityRepo().findAll();
    }

    @ApiOperation("To return city by Id")
    @GetMapping("/city/{id}")
    public ResponseEntity<?> getCitiesById (@PathVariable Long id){
        return service.getCityRepo().findById(id).map(record -> {
            return ResponseEntity.ok(new ApiResponse<>(CustomMessages.Success, record));
        }).orElseThrow(()-> new RecordNotFoundException(NotFoundMessage + id));
    }

    @ApiOperation("To delete a city record by Id")
    @DeleteMapping("/city/{id}")
    public ResponseEntity<?> deleteCityById(@PathVariable ("id") Long id){
        return service.getCityRepo().findById(id).map(record ->  {
            service.getCityRepo().deleteById(id);
            return ResponseEntity.ok(new ApiResponse<>(CustomMessages.Deleted, CustomMessages.DeletedMessage));
        }).orElseThrow(()-> new RecordNotFoundException(NotFoundMessage+ id));
    }

    //</editor-fold

    //<editor-fold desc = "Service Provider"

    @ApiOperation("To save a service provider record")
    @PostMapping("/save/serviceProvider")
    public ResponseEntity<?> saveServiceProvider(@RequestBody ServiceProvider serviceProvider){
        ServiceProvider sp = service.getServiceProviderRepo().save(serviceProvider);
        return ResponseEntity.ok(new ApiResponse<>(CustomMessages.Success, sp));
    }

    @ApiOperation("To return all service provider records")
    @GetMapping("/serviceProvider")
    public List<ServiceProvider> getAllServiceProvider(){
        return service.getServiceProviderRepo().findAll();
    }

    @ApiOperation("To return service provider by Id")
    @GetMapping("/serviceProvider/{id}")
    public ResponseEntity<?> getServiceProviderById(@PathVariable ("id") Long id){
        return service.getServiceProviderRepo().findById(id).map(record -> {
            return ResponseEntity.ok(new ApiResponse<>(CustomMessages.Success, record));
        }).orElseThrow(()-> new RecordNotFoundException(NotFoundMessage + id));
    }

    @ApiOperation("To delete a service provider record by Id")
    @DeleteMapping("/serviceProvider/{id}")
    public ResponseEntity<?> deleteServiceProviderById(@PathVariable ("id") Long id){
        return service.getServiceProviderRepo().findById(id).map(record -> {
            service.getServiceProviderRepo().deleteById(id);
            return ResponseEntity.ok(new ApiResponse<>(CustomMessages.Deleted, CustomMessages.DeletedMessage));
        }).orElseThrow(()-> new RecordNotFoundException(NotFoundMessage + id));
    }

    @ApiOperation("To return list of service providers by City")
    @GetMapping("/serviceProvider/search/{parameter}")
    public ResponseEntity<?> getServiceProviderByCity (@PathVariable ("parameter") String parameter) {
        Optional<List<ServiceProvider>> sp = service.getServiceProviderRepo().findServiceProviderByCity_Name(parameter);

        if (!sp.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(CustomMessages.NotFound, CustomMessages.NotFoundMessage));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(CustomMessages.Success, sp.get()));

        }
    }

    @ApiOperation("To return list of service provider records by city short name")
    @GetMapping("/serviceProvider/searchBy/{shortName}")
    public ResponseEntity<?> getServiceProviderByCityShortName(String shortName){
        Optional<List<ServiceProvider>> sp = service.getServiceProviderRepo().findServiceProviderByCityShortName(shortName);

        if (!sp.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(CustomMessages.NotFound, CustomMessages.NotFoundMessage));
        }else {
            return ResponseEntity.ok(new ApiResponse<>(CustomMessages.Success, sp.get()));
        }
    }
    //</editor-fold
}
