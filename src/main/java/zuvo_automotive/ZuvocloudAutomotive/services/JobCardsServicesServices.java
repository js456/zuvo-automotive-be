package zuvo_automotive.ZuvocloudAutomotive.services;

import org.hibernate.mapping.Array;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuvo_automotive.ZuvocloudAutomotive.dto.JobCardServicesDTO;
import zuvo_automotive.ZuvocloudAutomotive.dto.JobCardsDTO;
import zuvo_automotive.ZuvocloudAutomotive.entity.JobCardServices;
import zuvo_automotive.ZuvocloudAutomotive.entity.JobCards;
import zuvo_automotive.ZuvocloudAutomotive.repository.JobCardServicesRepo;
import zuvo_automotive.ZuvocloudAutomotive.repository.JobCardsRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobCardsServicesServices {
    @Autowired
    private JobCardServicesRepo jobCardServicesRepo;

    public List<JobCardServicesDTO> getAll() {
        List<JobCardServices> jobCardServices = jobCardServicesRepo.findAll();
        List<JobCardServicesDTO> jobCardServicesDTOS = new ArrayList<>();
        for (JobCardServices jobCardServices1 : jobCardServices) {
            JobCardServicesDTO jobCardServicesDTO = new JobCardServicesDTO();
            jobCardServicesDTO.setJobCardId(jobCardServices1.getJobCardId().getId());
            jobCardServicesDTO.setServiceId(jobCardServices1.getServiceId());
            jobCardServicesDTO.setQuantity(jobCardServices1.getQuantity());
            jobCardServicesDTO.setCreatedAt(jobCardServices1.getCreatedAt());
            jobCardServicesDTO.setPriceAtTime(jobCardServices1.getPriceAtTime());

            jobCardServicesDTOS.add(jobCardServicesDTO);
        }
        return jobCardServicesDTOS;
    }


    public JobCardServices findById(int id) {
        JobCardServices jobCardServices = jobCardServicesRepo.findById(id)
                .orElseThrow(()->new RuntimeException("jobCardServices not found with id :"+id));
        return jobCardServices;
    }
    public JobCardServices createJobCardServices(JobCardServicesDTO jobCardServicesDTO){
        try {
            JobCardServices jobCardServices = new JobCardServices();
            jobCardServices.setId(jobCardServicesDTO.getId());
            jobCardServices.setCreatedAt(jobCardServicesDTO.getCreatedAt());
            jobCardServices.setServiceId(jobCardServicesDTO.getServiceId());
            jobCardServices.setQuantity(jobCardServicesDTO.getQuantity());
            jobCardServices.setPriceAtTime(jobCardServicesDTO.getPriceAtTime());
//            jobCardServices.setJobCardId(jobCardServicesDTO.getJobCardId());
            return jobCardServices;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public JobCardServices updateJobCardServices(JobCardServicesDTO jobCardServicesDTO){
        try {
            JobCardServices jobCardServices = new JobCardServices();
            jobCardServices.setId(jobCardServicesDTO.getId());
            jobCardServices.setCreatedAt(jobCardServicesDTO.getCreatedAt());
            jobCardServices.setServiceId(jobCardServicesDTO.getServiceId());
            jobCardServices.setQuantity(jobCardServicesDTO.getQuantity());
            jobCardServices.setPriceAtTime(jobCardServicesDTO.getPriceAtTime());
          //  jobCardServices.setJobCardId(jobCardServicesDTO.getJobCardId());
            return jobCardServices;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
