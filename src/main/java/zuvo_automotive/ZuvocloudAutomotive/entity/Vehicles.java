package zuvo_automotive.ZuvocloudAutomotive.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vehicles")
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customerId")
    private int customerId;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Year year;
    @Column(name = "licensePlate")
    private String licensePlate;
    @Column(name = "vin")
    private int  vin;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "deleted",nullable = false)
    private boolean deleted;

}
