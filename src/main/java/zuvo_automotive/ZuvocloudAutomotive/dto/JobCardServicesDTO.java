package zuvo_automotive.ZuvocloudAutomotive.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zuvo_automotive.ZuvocloudAutomotive.entity.JobCards;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobCardServicesDTO {

    private int id;
    private int jobCardId;
    private int serviceId;
    private String quantity;
    private String priceAtTime;
    private LocalDateTime createdAt;
}
