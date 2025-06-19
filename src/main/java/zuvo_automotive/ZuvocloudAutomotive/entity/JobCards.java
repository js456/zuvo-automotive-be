package zuvo_automotive.ZuvocloudAutomotive.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zuvo_automotive.ZuvocloudAutomotive.dto.JobCardsDTO;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jobCards")
public class JobCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tenantId")
    private int tenantId;
    @Column(name = "customerId")
    private int customerId;
    @Column(name = "vehicleId")
    private int vehicleId;
    @Column(name = "status")
    private int status;
    @Column(name = "notes")
    private String notes;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = true;

}
