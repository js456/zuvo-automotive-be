package com.zuvocloud.automotive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TenantsDTO {
    private int id;
    private String name;
    private String address;
    private String  city;
    private String state;
    private int  zipCode;
    private String phone;
    private LocalDateTime createdAt;
}
