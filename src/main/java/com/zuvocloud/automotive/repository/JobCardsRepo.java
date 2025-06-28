package com.zuvocloud.automotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zuvocloud.automotive.entity.JobCards;
@Repository
public interface JobCardsRepo extends JpaRepository<JobCards,Integer> {
}
