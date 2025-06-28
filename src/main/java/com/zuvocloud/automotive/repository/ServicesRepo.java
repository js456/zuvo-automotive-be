package com.zuvocloud.automotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zuvocloud.automotive.entity.Services;
@Repository
public interface ServicesRepo extends JpaRepository<Services,Integer> {
}
