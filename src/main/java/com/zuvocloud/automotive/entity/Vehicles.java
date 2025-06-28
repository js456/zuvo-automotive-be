package com.zuvocloud.automotive.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vehicles")
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "customer_id")
//    private int customerId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Year year;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "vin")
    private int  vin;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "deleted",nullable = false)
    private boolean deleted;

}
