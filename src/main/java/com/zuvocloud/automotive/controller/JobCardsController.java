package com.zuvocloud.automotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zuvocloud.automotive.dto.JobCardRequestDTO;
import com.zuvocloud.automotive.dto.JobCardsDTO;
import com.zuvocloud.automotive.entity.JobCards;

import com.zuvocloud.automotive.services.JobCardsServices1;

import java.util.List;

@RestController
@RequestMapping("/jobCards")
public class JobCardsController {
    @Autowired
    private JobCardsServices1 jobCardServices1;

    @GetMapping
    public ResponseEntity<List<JobCardsDTO>> getAll() {
        List<JobCardsDTO> jobCardsDTOS = jobCardServices1.getAll();
        return new ResponseEntity<>(jobCardsDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobCards> findById(@PathVariable("id") int id) {
        JobCards jobCards = jobCardServices1.findById(id);
        return new ResponseEntity<>(jobCards, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobCards> createJobCards(@RequestBody JobCardsDTO jobCardsDTO) {
        JobCards jobCards = jobCardServices1.createJobCards(jobCardsDTO);
        return new ResponseEntity<>(jobCards, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<JobCards> updateJobCards(@RequestBody JobCardsDTO jobCardsDTO) {
        JobCards jobCards = jobCardServices1.updateJobCards(jobCardsDTO);
        return new ResponseEntity<>(jobCards, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobCards> deleteJobCards(@PathVariable int id) {
        JobCards jobCards = jobCardServices1.deleteJobCards(id);
        return new ResponseEntity<>(jobCards, HttpStatus.OK);
    }

    @PostMapping("/jobCard")
    public ResponseEntity<JobCardRequestDTO> createJobCardRequest(@RequestBody JobCardRequestDTO jobCardRequestDTO) {
        JobCardRequestDTO jobCardRequestDTO1 = jobCardServices1.createJobCardRequest(jobCardRequestDTO);
        return new ResponseEntity<>(jobCardRequestDTO1,HttpStatus.OK);
    }

}
