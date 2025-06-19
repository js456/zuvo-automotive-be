package zuvo_automotive.ZuvocloudAutomotive.entity;

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
    @Column(name = "jobCardId")
    private int jobCardId;
    @Column(name = "invoiceDate")
    private LocalDateTime invoiceDate;
    @Column(name = "subTotal")
    private int subTotal;
    @Column(name = "tax")
    private double tax;
    @Column(name = "discount")
    private int discount;
    @Column(name = "totalAmount")
    private int totalAmount;
    @Column(name = "paymentStatus")
    private String paymentStatus;
    @Column(name = "paymentMethod")
    private String paymentMethod;
    @Column(name = "generatedAt")
    private LocalDateTime generatedAt;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = true;
}

