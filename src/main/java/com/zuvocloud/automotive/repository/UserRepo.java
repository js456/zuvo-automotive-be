package com.zuvocloud.automotive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zuvocloud.automotive.entity.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User , Integer> {
    List<User> findByDeletedFalse();

}
