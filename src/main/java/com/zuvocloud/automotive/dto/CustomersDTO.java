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
public class CustomersDTO {
    private int id;
    private  int tenantId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime createdAt;
}
