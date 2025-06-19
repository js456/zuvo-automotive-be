package zuvo_automotive.ZuvocloudAutomotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zuvo_automotive.ZuvocloudAutomotive.dto.TenantsDTO;
import zuvo_automotive.ZuvocloudAutomotive.entity.Tenants;
import zuvo_automotive.ZuvocloudAutomotive.services.TenantsServices;

import java.util.List;

@RestController
@RequestMapping("/tenants")
public class TenantsController {
    @Autowired
    private TenantsServices tenantsServices;

    @GetMapping("/tenants")
    public ResponseEntity<List<TenantsDTO>>getAll(){
        List<TenantsDTO>tenantsDTOS = tenantsServices.getAll();
        return new ResponseEntity<>(tenantsDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Tenants>findById(@PathVariable ("id") int id){
        Tenants tenants = tenantsServices.findById(id);
        return new ResponseEntity<>(tenants,HttpStatus.OK);
    }
    @PostMapping("createTenants")
    public  ResponseEntity<Tenants> createTenants(@RequestBody TenantsDTO tenantsDTO){
        Tenants tenants = tenantsServices.createTenants(tenantsDTO);
        return new ResponseEntity<>(tenants,HttpStatus.CREATED);
    }
    @PutMapping("/updateTenants")
    public ResponseEntity<Tenants>updateTenant(@RequestBody TenantsDTO tenantsDTO){
        Tenants tenants = tenantsServices.createTenants(tenantsDTO);
        return  new ResponseEntity<>(tenants,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Tenants>deleteTenants(@PathVariable int id ){
        Tenants tenants = tenantsServices.deleteTenants(id);
        return new ResponseEntity<>(tenants,HttpStatus.OK);

    }
}
