package com.zuvocloud.automotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zuvocloud.automotive.dto.ServicesDTO;
import com.zuvocloud.automotive.entity.Services;
import com.zuvocloud.automotive.services.ServicesServices;

import java.util.List;
@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesServices servicesServices ;
    @GetMapping
    public ResponseEntity<List<ServicesDTO>> getAll(){
        List<ServicesDTO> servicesDTOList =servicesServices.getAll();
        return new ResponseEntity<>(servicesDTOList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity <Services> findById(@PathVariable("id")int id){
        Services services = servicesServices.findById(id);
        return  new ResponseEntity<>(services,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity <Services> createService(@RequestBody ServicesDTO servicesDTO){
        Services services = servicesServices.createService(servicesDTO);
        return new ResponseEntity<>(services,HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Services> updateService(@RequestBody ServicesDTO servicesDTO){
        Services services = servicesServices.updateService(servicesDTO);
        return new ResponseEntity<>(services,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Services> deleteServices(@PathVariable int id){
        Services deleteServices =servicesServices.deleteServices(id);
        return new ResponseEntity<>(deleteServices,HttpStatus.OK);
    }


}

