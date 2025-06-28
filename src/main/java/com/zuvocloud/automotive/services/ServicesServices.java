package com.zuvocloud.automotive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zuvocloud.automotive.dto.ServicesDTO;
import com.zuvocloud.automotive.entity.Services;
import com.zuvocloud.automotive.repository.ServicesRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class
ServicesServices {
    @Autowired
    private ServicesRepo servicesRepo;
    public List<ServicesDTO> getAll(){
        List<Services> servicess = servicesRepo.findAll();
        List<ServicesDTO>servicesDTOS = new ArrayList<>();
        for (Services services :servicess){
            ServicesDTO dto1 = new ServicesDTO();
            dto1.setName(services.getName());
            dto1.setTenantId(services.getTenantId());
            dto1.setCreatedAt(services.getCreatedAt());
            dto1.setDescription(services.getDescription());
            dto1.setPrice(services.getPrice());
            dto1.setDurationMinutes(services.getDurationMinutes());
            servicesDTOS.add(dto1);
        }
        return servicesDTOS;
    }

    public Services findById(int id) {
        Services services = servicesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return services;
    }

    public Services createService(ServicesDTO servicesDTO) {
        try{
            Services services = new Services();
            services.setCreatedAt(servicesDTO.getCreatedAt());
            services.setName(servicesDTO.getName());
            services.setPrice(servicesDTO.getPrice());
            services.setDescription(servicesDTO.getDescription());
            services.setDurationMinutes(servicesDTO.getDurationMinutes());
            services.setTenantId(servicesDTO.getTenantId());
            Services services1 = servicesRepo.save(services);
            return services1;
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Services updateService(ServicesDTO servicesDTO) {
        try {
            Services services = servicesRepo.findById(servicesDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Services not found with id: " ));

            services.setId(servicesDTO.getTenantId());
            services.setTenantId(servicesDTO.getTenantId());
            services.setCreatedAt(servicesDTO.getCreatedAt());
            services.setName(servicesDTO.getName());
            services.setPrice(servicesDTO.getPrice());
            services.setDescription(services.getDescription());
            services.setDurationMinutes(services.getDurationMinutes());

            return servicesRepo.save(services);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Services deleteServices(int id) {
        Services services = servicesRepo.findById(id)
                .orElseThrow(()->new RuntimeException("services not found with id"+id));
        services.setDeleted(true);
        return servicesRepo.save(services);
    }
}