package com.zuvocloud.automotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zuvocloud.automotive.entity.Customers;
@Repository
public interface CustomersRepo extends JpaRepository<Customers,Integer> {

}
