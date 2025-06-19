package zuvo_automotive.ZuvocloudAutomotive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zuvo_automotive.ZuvocloudAutomotive.dto.JobCardsDTO;
import zuvo_automotive.ZuvocloudAutomotive.entity.JobCards;
import zuvo_automotive.ZuvocloudAutomotive.repository.JobCardsRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobCardsServices1 {
    @Autowired
    private JobCardsRepo jobCardsRepo;

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
            jobCardsDTO.setVehicleId(jobCards1.getVehicleId());
            jobCardsDTOS.add(jobCardsDTO);

        }
        return jobCardsDTOS;
    }
    public JobCards findById(int id) {
        JobCards jobCards = jobCardsRepo.findById(id)
                .orElseThrow(()->new RuntimeException("jobcards not found with id"+id));
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
            jobCards.setVehicleId(jobCardsDTO.getVehicleId());
            jobCards.setCustomerId(jobCardsDTO.getCustomerId());
            JobCards jobCardsDTO2 =jobCardsRepo.save(jobCards);
            return jobCardsDTO2;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public JobCards
    updateJobCards(JobCardsDTO jobCardsDTO){
        try {
            JobCards jobCards = new JobCards();
            jobCards.setId(jobCardsDTO.getId());
            jobCards.setCreatedAt(jobCardsDTO.getCreatedAt());
            jobCards.setTenantId(jobCardsDTO.getTenantId());
            jobCards.setStatus(jobCardsDTO.getStatus());
            jobCards.setUpdatedAt(jobCardsDTO.getUpdatedAt());
            jobCards.setNotes(jobCardsDTO.getNotes());
            jobCards.setVehicleId(jobCardsDTO.getVehicleId());
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
