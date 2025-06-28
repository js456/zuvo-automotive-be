package com.zuvocloud.automotive.dto;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoicesDTO {
    private int id;
    private int jobCardId;
    private LocalDateTime invoiceDate;
    private int subTotal;
    private double tax;
    private int discount;
    private int totalAmount;
    private String paymentStatus;
    private String paymentMethod;
    private LocalDateTime  generatedAt;

}
