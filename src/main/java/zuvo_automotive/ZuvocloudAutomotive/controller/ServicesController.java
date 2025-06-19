package zuvo_automotive.ZuvocloudAutomotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuvo_automotive.ZuvocloudAutomotive.dto.ServicesDTO;
import zuvo_automotive.ZuvocloudAutomotive.entity.Services;
import zuvo_automotive.ZuvocloudAutomotive.services.ServicesServices;

import java.util.List;
@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesServices servicesServices ;
    @GetMapping("/ss")
    public ResponseEntity<List<ServicesDTO>> getAll(){
        List<ServicesDTO> servicesDTOList =servicesServices.getAll();
        return new ResponseEntity<>(servicesDTOList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity <Services> findById(@PathVariable("id")int id){
        Services services = servicesServices.findById(id);
        return  new ResponseEntity<>(services,HttpStatus.OK);
    }
    @PostMapping("/createService")
    public ResponseEntity <Services> createService(@RequestBody ServicesDTO servicesDTO){
        Services services = servicesServices.createService(servicesDTO);
        return new ResponseEntity<>(services,HttpStatus.CREATED);
    }
    @PutMapping("/updateService")
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

