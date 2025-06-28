package com.zuvocloud.automotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zuvocloud.automotive.dto.JobCardServicesDTO;
import com.zuvocloud.automotive.entity.JobCardServices;
import com.zuvocloud.automotive.services.JobCardsServicesServices;

import java.util.List;

@RestController
@RequestMapping("/jobCardServices")
public class JobCardServicesController {
    @Autowired
    private JobCardsServicesServices jobCardsServicesServices;
    @GetMapping
    public ResponseEntity<List<JobCardServicesDTO>>gatAll(){
        List<JobCardServicesDTO>jobCardServicesDTOS = jobCardsServicesServices.getAll();
        return new ResponseEntity<>(jobCardServicesDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobCardServices>findByID(@PathVariable("id") int id){
         JobCardServices jobCardServices= jobCardsServicesServices.findById(id);
        return new ResponseEntity<>(jobCardServices,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<JobCardServices>createJobCardServices(@RequestBody JobCardServicesDTO jobCardServicesDTO){
        JobCardServices jobCardServices = jobCardsServicesServices.createJobCardServices(jobCardServicesDTO);
        return new ResponseEntity<>(jobCardServices,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<JobCardServices>updateJobCardServices(@RequestBody JobCardServicesDTO jobCardServicesDTO){
        JobCardServices jobCardServices = jobCardsServicesServices.updateJobCardServices(jobCardServicesDTO);
        return new ResponseEntity<>(jobCardServices,HttpStatus.OK);
    }

}

