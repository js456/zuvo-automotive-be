package zuvo_automotive.ZuvocloudAutomotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zuvo_automotive.ZuvocloudAutomotive.entity.JobCards;
@Repository
public interface JobCardsRepo extends JpaRepository<JobCards,Integer> {
}
