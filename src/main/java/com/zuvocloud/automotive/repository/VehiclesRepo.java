package com.zuvocloud.automotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zuvocloud.automotive.entity.Vehicles;
@Repository
public interface VehiclesRepo extends JpaRepository<Vehicles,Integer> {
}
