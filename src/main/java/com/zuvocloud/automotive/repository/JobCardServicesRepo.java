package com.zuvocloud.automotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zuvocloud.automotive.entity.JobCardServices;
@Repository
public interface JobCardServicesRepo extends JpaRepository<JobCardServices,Integer> {
}
