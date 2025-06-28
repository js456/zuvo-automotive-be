package com.zuvocloud.automotive.services;

import com.zuvocloud.automotive.entity.JobCardServices;
import com.zuvocloud.automotive.enums.JobCardStatus;
import com.zuvocloud.automotive.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zuvocloud.automotive.dto.JobCardRequestDTO;
import com.zuvocloud.automotive.dto.JobCardsDTO;
import com.zuvocloud.automotive.entity.Customers;
import com.zuvocloud.automotive.entity.JobCards;
import com.zuvocloud.automotive.entity.Vehicles;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobCardsServices1 {
    @Autowired
    private JobCardsRepo jobCardsRepo;
    @Autowired
    private ServicesRepo servicesRepo;
    @Autowired
    private CustomersRepo customersRepo;
    @Autowired
    private VehiclesRepo vehiclesRepo;

    @Autowired
    private JobCardServicesRepo jobCardServicesRepo;

    public  JobCardRequestDTO createJobCardRequest(JobCardRequestDTO jobCardRequestDTO) {
            Customers customer = new Customers();
            customer.setName(jobCardRequestDTO.getCustomerRequestDTO().getName());
            customer.setPhone(jobCardRequestDTO.getCustomerRequestDTO().getPhone());
            customer.setEmail(jobCardRequestDTO.getCustomerRequestDTO().getEmail());
            customer.setAddress(jobCardRequestDTO.getCustomerRequestDTO().getAddress());
            customer= customersRepo.save(customer);

            Vehicles vehicle = new Vehicles();
            vehicle.setMake(jobCardRequestDTO.getVehicleRequestDTO().getMake());
            vehicle.setYear(Year.of(jobCardRequestDTO.getVehicleRequestDTO().getYear()));
            vehicle.setModel(jobCardRequestDTO.getVehicleRequestDTO().getModel());
            vehicle.setVin(Integer.parseInt(jobCardRequestDTO.getVehicleRequestDTO().getVin()));
            vehicle.setLicensePlate(jobCardRequestDTO.getVehicleRequestDTO().getLicensePlate());
            vehicle.setCustomer(customer);
            vehicle=vehiclesRepo.save(vehicle);


            JobCards jobCards = new JobCards();
            jobCards.setStatus(JobCardStatus.OPEN.getId());
            jobCards.setNotes(jobCardRequestDTO.getComment());
            jobCards.setCustomerId(customer);
            jobCards.setVehiclesId(vehicle);

            JobCards jobCards1=  jobCardsRepo.save(jobCards);
            List <Integer> ids = new ArrayList<>();
            ids = jobCardRequestDTO.getServicesIdList();


            for(Integer j: ids){
                JobCardServices jobCardServices = new JobCardServices();
                jobCardServices.setServiceId(j);
                jobCardServices.setQuantity("1");
                jobCardServices.setJobCardId(jobCards1);
                jobCardServicesRepo.save(jobCardServices);
            }

            return jobCardRequestDTO;

    }

    public List<JobCardsDTO> getAll() {
        List<JobCards> jobCards = jobCardsRepo.findAll();
        List<JobCardsDTO> jobCardsDTOS = new ArrayList<>();
        for (JobCards jobCards1 : jobCards) {
            JobCardsDTO jobCardsDTO = new JobCardsDTO();
            jobCardsDTO.setId(jobCards1.getId());
            jobCardsDTO.setStatus(jobCards1.getStatus());
            jobCardsDTO.setTenantId(jobCards1.getTenantId());
            jobCardsDTO.setCreatedAt(jobCards1.getCreatedAt());
            jobCardsDTO.setCustomerId(jobCards1.getCustomerId());
            jobCardsDTO.setUpdatedAt(jobCards1.getUpdatedAt());
            jobCardsDTO.setNotes(jobCards1.getNotes());
            jobCardsDTO.setVehicleId(jobCards1.getVehiclesId());
            jobCardsDTOS.add(jobCardsDTO);

        }
        return jobCardsDTOS;
    }
    public JobCards findById(int id) {
        JobCards jobCards = jobCardsRepo.findById(id)
                .orElseThrow(()->new RuntimeException("jobCards not found with id"+id));
        return jobCards;
    }

    public JobCards createJobCards(JobCardsDTO jobCardsDTO) {
        try {
            JobCards jobCards = new JobCards();
            jobCards.setId(jobCardsDTO.getId());
            jobCards.setCreatedAt(jobCardsDTO.getCreatedAt());
            jobCards.setTenantId(jobCardsDTO.getTenantId());
            jobCards.setStatus(jobCardsDTO.getStatus());
            jobCards.setUpdatedAt(jobCardsDTO.getUpdatedAt());
            jobCards.setNotes(jobCardsDTO.getNotes());
           // jobCards.setCustomer(jobCardsDTO);
            jobCards.setCustomerId(jobCardsDTO.getCustomerId());
            JobCards jobCardsDTO2 =jobCardsRepo.save(jobCards);
            return jobCardsDTO2;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public JobCards updateJobCards(JobCardsDTO jobCardsDTO){
        try {
            JobCards jobCards = new JobCards();
            jobCards.setId(jobCardsDTO.getId());
            jobCards.setCreatedAt(jobCardsDTO.getCreatedAt());
            jobCards.setTenantId(jobCardsDTO.getTenantId());
            jobCards.setStatus(jobCardsDTO.getStatus());
            jobCards.setUpdatedAt(jobCardsDTO.getUpdatedAt());
            jobCards.setNotes(jobCardsDTO.getNotes());
           // jobCards.setVehicleId(jobCardsDTO.getVehicleId());
            jobCards.setVehiclesId(jobCardsDTO.getVehicleId());
            jobCards.setCustomerId(jobCardsDTO.getCustomerId());
            JobCards jobCards1 =jobCardsRepo.save(jobCards);
            return jobCards1;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public JobCards deleteJobCards(int id) {
        JobCards jobCards = jobCardsRepo.findById(id)
                .orElseThrow(()->new RuntimeException("job cards not found with id"+id));
        jobCards.setDeleted(false);
        return jobCardsRepo.save(jobCards);
    }
}