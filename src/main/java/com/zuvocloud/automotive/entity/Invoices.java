package com.zuvocloud.automotive.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="invoices")
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "job-card_id")
    private int jobCardId;
    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;
    @Column(name = "sub_total")
    private int subTotal;
    @Column(name = "tax")
    private double tax;
    @Column(name = "discount")
    private int discount;
    @Column(name = "total_amount")
    private int totalAmount;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "generated_at")
    private LocalDateTime generatedAt;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = true;
}

