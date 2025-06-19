package zuvo_automotive.ZuvocloudAutomotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuvo_automotive.ZuvocloudAutomotive.dto.JobCardServicesDTO;
import zuvo_automotive.ZuvocloudAutomotive.dto.JobCardsDTO;
import zuvo_automotive.ZuvocloudAutomotive.entity.JobCardServices;
import zuvo_automotive.ZuvocloudAutomotive.services.JobCardsServicesServices;

import java.util.List;

@RestController
@RequestMapping("/jobCardServices")
public class JobCardServicesController {
    @Autowired
    private JobCardsServicesServices jobCardsServicesServices;
    @GetMapping("/jobCardServices")
    public ResponseEntity<List<JobCardServicesDTO>>gatAll(){
        List<JobCardServicesDTO>jobCardServicesDTOS = jobCardsServicesServices.getAll();
        return new ResponseEntity<>(jobCardServicesDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobCardServices>findByID(@PathVariable("id") int id){
         JobCardServices jobCardServices= jobCardsServicesServices.findById(id);
        return new ResponseEntity<>(jobCardServices,HttpStatus.OK);
    }
    @PostMapping("/createJobCardServices")
    public ResponseEntity<JobCardServices>createJobCardServices(@RequestBody JobCardServicesDTO jobCardServicesDTO){
        JobCardServices jobCardServices = jobCardsServicesServices.createJobCardServices(jobCardServicesDTO);
        return new ResponseEntity<>(jobCardServices,HttpStatus.OK);
    }
    @PutMapping("/updateJobCardServices")
    public ResponseEntity<JobCardServices>updateJobCardServices(@RequestBody JobCardServicesDTO jobCardServicesDTO){
        JobCardServices jobCardServices = jobCardsServicesServices.updateJobCardServices(jobCardServicesDTO);
        return new ResponseEntity<>(jobCardServices,HttpStatus.OK);
    }

}

