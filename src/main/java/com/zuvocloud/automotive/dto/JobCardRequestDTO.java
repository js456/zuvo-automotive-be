package com.zuvocloud.automotive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCardRequestDTO {
   private CustomerRequestDTO customerRequestDTO;
   private VehicleRequestDTO vehicleRequestDTO;
   private List<CustomServiceDTO>customServiceDTOList;
   private List<Integer>servicesIdList;
   private Date deliveryDate;
   private  String comment;

}