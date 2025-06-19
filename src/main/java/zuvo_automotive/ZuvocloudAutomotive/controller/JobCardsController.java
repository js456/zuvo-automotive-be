package zuvo_automotive.ZuvocloudAutomotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuvo_automotive.ZuvocloudAutomotive.dto.JobCardsDTO;
import zuvo_automotive.ZuvocloudAutomotive.entity.JobCards;
import zuvo_automotive.ZuvocloudAutomotive.services.JobCardsServices1;

import java.util.List;

@RestController
@RequestMapping("/jobCards")
public class JobCardsController {
    @Autowired
    private JobCardsServices1 jobCardServices1;
    @GetMapping("/jobCards")
    public ResponseEntity<List<JobCardsDTO>>getAll(){
        List<JobCardsDTO>jobCardsDTOS = jobCardServices1.getAll();
        return new ResponseEntity<>(jobCardsDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<JobCards>findById(@PathVariable("id")int id){
        JobCards jobCards = jobCardServices1.findById(id);
        return new ResponseEntity<>(jobCards,HttpStatus.OK);
    }
    @PostMapping("/crateJobCards")
    public ResponseEntity<JobCards>createJobCards(@RequestBody JobCardsDTO jobCardsDTO){
        JobCards jobCards =jobCardServices1.createJobCards(jobCardsDTO);
        return new ResponseEntity<>(jobCards,HttpStatus.OK);
    }
    @PutMapping("/updateJobCards")
    public ResponseEntity<JobCards>updateJobCards(@RequestBody JobCardsDTO jobCardsDTO){
        JobCards jobCards = jobCardServices1.updateJobCards(jobCardsDTO);
        return new ResponseEntity<>(jobCards,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<JobCards>deleteJobCards(@PathVariable int id){
        JobCards jobCards= jobCardServices1.deleteJobCards(id);
        return new ResponseEntity<>(jobCards,HttpStatus.OK);
    }

}
