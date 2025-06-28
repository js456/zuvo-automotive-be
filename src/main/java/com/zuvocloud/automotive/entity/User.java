package com.zuvocloud.automotive.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tenant_id")
    private int tenantId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private  String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password_hash")
    private int password_hash;

    @Column(name = "role")
    private String role;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

}
