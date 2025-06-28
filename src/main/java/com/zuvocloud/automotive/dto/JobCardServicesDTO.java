package com.zuvocloud.automotive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCardServicesDTO {

    private int id;
    private int jobCardId;
    private int serviceId;
    private String quantity;
    private String priceAtTime;
    private LocalDateTime createdAt;
}
