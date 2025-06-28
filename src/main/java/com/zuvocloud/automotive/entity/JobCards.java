package com.zuvocloud.automotive.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_cards")
public class JobCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tenant-id")
    private int tenantId;
//    @Column(name = "customer_id")
//    private int customerId;
//    @Column(name = "vehicle_id")
//    private int vehicleId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customerId;
    @ManyToOne
    @JoinColumn(name ="vehicle_id" )
    private Vehicles vehiclesId;

    @Column(name = "status")
    private int status;
    @Column(name = "notes")
    private String notes;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = true;

}
