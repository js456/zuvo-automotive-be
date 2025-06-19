package zuvo_automotive.ZuvocloudAutomotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zuvo_automotive.ZuvocloudAutomotive.entity.Customers;
import zuvo_automotive.ZuvocloudAutomotive.entity.JobCardServices;
@Repository
public interface JobCardServicesRepo extends JpaRepository<JobCardServices,Integer> {
}
