package com.zuvocloud.automotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zuvocloud.automotive.dto.VehiclesDTO;
import com.zuvocloud.automotive.entity.Vehicles;
import com.zuvocloud.automotive.services.VehiclesServices;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    @Autowired
    private VehiclesServices vehiclesServices;
    @GetMapping
    public ResponseEntity<List<VehiclesDTO>>getAll(){
        List<VehiclesDTO>vehiclesDTO = vehiclesServices.getAll();
        return new ResponseEntity<>(vehiclesDTO, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Vehicles> findById(@PathVariable ("id")int id){
        Vehicles vehicles = vehiclesServices.findById(id);
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Vehicles>createVehicles(@RequestBody VehiclesDTO vehiclesDTO){
        Vehicles vehicles = vehiclesServices.createVehicles(vehiclesDTO);
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Vehicles>updateVehicles(@RequestBody VehiclesDTO vehiclesDTO){
        Vehicles vehicles = vehiclesServices.updateVehicles(vehiclesDTO);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicles>deleteVehicles(@PathVariable int id){
        Vehicles vehicles= vehiclesServices.deleteVehicles(id);
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
}
