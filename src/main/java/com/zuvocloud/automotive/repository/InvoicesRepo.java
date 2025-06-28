package com.zuvocloud.automotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zuvocloud.automotive.entity.Invoices;
@Repository
public interface InvoicesRepo extends JpaRepository<Invoices,Integer> {
}
