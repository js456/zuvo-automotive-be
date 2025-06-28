package com.zuvocloud.automotive.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ServicesDTO {
    private Integer id;
    private Integer tenantId;
    private String name;
    private String description;
    private Double price;
    private Double durationMinutes;
    private LocalDateTime createdAt;
}
