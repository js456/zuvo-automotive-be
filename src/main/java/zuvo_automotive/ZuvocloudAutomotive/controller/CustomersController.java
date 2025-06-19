package zuvo_automotive.ZuvocloudAutomotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuvo_automotive.ZuvocloudAutomotive.dto.CustomersDTO;
import zuvo_automotive.ZuvocloudAutomotive.entity.Customers;
import zuvo_automotive.ZuvocloudAutomotive.services.CustomerServices;

import java.util.List;

@RestController
@RequestMapping("/custumers")
public class CustomersController {
    @Autowired
    private CustomerServices customerServices;
    @GetMapping("/custumers")
    public ResponseEntity <List<CustomersDTO>> getAll(){
        List<CustomersDTO>customersDTOS = customerServices.getAll();
        return new ResponseEntity<>(customersDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customers> findById(@PathVariable ("id") int id){
        Customers customers = customerServices.findById(id);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @PostMapping("/createCustomers")
    public ResponseEntity<Customers>createCustomers(@RequestBody CustomersDTO customersDTO){
        Customers customers =customerServices.createCustomer(customersDTO);
        return new ResponseEntity<>(customers,HttpStatus.CREATED);
    }
    @PutMapping("/updateCustomrs")
    public  ResponseEntity<Customers>updateCustomers(@RequestBody CustomersDTO customersDTO){
        Customers customers = customerServices.updateCustomers(customersDTO);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Customers>deleteCustomers(@PathVariable  int id){
        Customers deleteCustomers = customerServices.deleteCustomers(id);
        return  new ResponseEntity<>(deleteCustomers, HttpStatus.OK);
    }
}
