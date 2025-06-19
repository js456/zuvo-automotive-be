package zuvo_automotive.ZuvocloudAutomotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zuvo_automotive.ZuvocloudAutomotive.entity.JobCards;
import zuvo_automotive.ZuvocloudAutomotive.entity.Vehicles;
@Repository
public interface VehiclesRepo extends JpaRepository<Vehicles,Integer> {
}
