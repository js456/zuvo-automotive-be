package com.zuvocloud.automotive.services;

import com.zuvocloud.automotive.entity.Customers;
import com.zuvocloud.automotive.repository.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zuvocloud.automotive.dto.VehiclesDTO;
import com.zuvocloud.automotive.entity.Vehicles;
import com.zuvocloud.automotive.repository.VehiclesRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiclesServices {
    @Autowired
    private VehiclesRepo vehiclesRepo;

    @Autowired
    CustomersRepo customersRepo;
    public List<VehiclesDTO> getAll(){
        List<Vehicles> vehicles = vehiclesRepo.findAll();
        List<VehiclesDTO>vehiclesDTOS = new ArrayList<>();
        for (Vehicles vehicles1:vehicles){
            VehiclesDTO vehiclesDTO= new VehiclesDTO();
            vehiclesDTO.setId(vehicles1.getId());
            vehiclesDTO.setCreatedAt(vehicles1.getCreatedAt());
            vehiclesDTO.setMake(vehicles1.getMake());
            vehiclesDTO.setModel(vehicles1.getModel());
            vehiclesDTO.setVin(vehicles1.getVin());
            vehiclesDTO.setCustomerId(vehicles1.getCustomer().getId());
            vehiclesDTO.setLicensePlate(vehicles1.getLicensePlate());
            vehiclesDTO.setYear(vehicles1.getYear());
            vehiclesDTOS.add(vehiclesDTO);
        }
        return vehiclesDTOS;
    }
    public Vehicles findById(int id){
        Vehicles vehicles=vehiclesRepo.findById(id)
                .orElseThrow(()->new RuntimeException("vehicles not fount with id"+id));
        return vehicles;
    }
    public  Vehicles createVehicles(VehiclesDTO vehiclesDTO){
        try {
            Customers customers = customersRepo.getById(vehiclesDTO.getCustomerId());
            Vehicles vehicles = new Vehicles();
            vehicles.setId(vehiclesDTO.getId());
            vehicles.setCreatedAt(vehiclesDTO.getCreatedAt());
            vehicles.setMake(vehiclesDTO.getMake());
            vehicles.setModel(vehiclesDTO.getModel());
            vehicles.setVin(vehiclesDTO.getVin());
            vehicles.setYear(vehiclesDTO.getYear());
            vehicles.setCustomer(customers);
            vehicles.setLicensePlate(vehiclesDTO.getLicensePlate());
            Vehicles vehicles1=vehiclesRepo.save(vehicles);
            return vehicles1;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Vehicles updateVehicles(VehiclesDTO vehiclesDTO){
        try {
            Customers customers = customersRepo.getById(vehiclesDTO.getCustomerId());
            Vehicles vehicles = new Vehicles();
            vehicles.setId(vehiclesDTO.getId());
            vehicles.setCreatedAt(vehiclesDTO.getCreatedAt());
            vehicles.setMake(vehiclesDTO.getMake());
            vehicles.setModel(vehiclesDTO.getModel());
            vehicles.setVin(vehiclesDTO.getVin());
            vehicles.setYear(vehiclesDTO.getYear());
           // vehicles .setCustomerId(vehiclesDTO.getCustomerId());
            vehicles.setCustomer(customers);
            vehicles.setLicensePlate(vehiclesDTO.getLicensePlate());
            Vehicles vehicles1=vehiclesRepo.save(vehicles);
            return vehicles1;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Vehicles deleteVehicles(int id) {
        Vehicles vehicles =vehiclesRepo.findById(id)
                .orElseThrow(()->new RuntimeException("vehicles not found with id"+id));
        vehicles.setDeleted(true);
        return vehicles;
    }
}
