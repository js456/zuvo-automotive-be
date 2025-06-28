package com.zuvocloud.automotive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomServiceDTO {

    private String name;
    private double price;
    private  String description;
    private Time durationMinutes;
}
