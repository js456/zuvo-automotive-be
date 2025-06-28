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
@Table(name="job_card_services")
public class JobCardServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_card_id", nullable = false)
    private JobCards jobCardId ;
    @Column(name = "service_id")
    private int serviceId;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "priceAt_time")
    private String priceAtTime;
    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
