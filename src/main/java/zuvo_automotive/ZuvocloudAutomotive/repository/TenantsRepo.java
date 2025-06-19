package zuvo_automotive.ZuvocloudAutomotive.repository;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zuvo_automotive.ZuvocloudAutomotive.entity.Tenants;

@Repository
public interface TenantsRepo extends JpaRepository<Tenants,Integer
        > {
}
