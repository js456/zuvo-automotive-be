package zuvo_automotive.ZuvocloudAutomotive.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jobCardServices")
public class JobCardServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobCardId", nullable = false)
    private JobCards jobCardId ;
    @Column(name = "serviceId")
    private int serviceId;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "priceAtTime")
    private String priceAtTime;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
   // private int jobCardId;

}
