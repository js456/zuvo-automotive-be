package com.zuvocloud.automotive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.zuvocloud.automotive.entity.Customers;
import com.zuvocloud.automotive.entity.Vehicles;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobCardsDTO {

    private int id;
    private int tenantId;
    private Customers customerId;
    private Vehicles vehicleId;
    private int status;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
