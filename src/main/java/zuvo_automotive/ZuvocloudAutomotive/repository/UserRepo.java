package zuvo_automotive.ZuvocloudAutomotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zuvo_automotive.ZuvocloudAutomotive.entity.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User , Integer> {
    List<User> findByDeletedFalse();

}
