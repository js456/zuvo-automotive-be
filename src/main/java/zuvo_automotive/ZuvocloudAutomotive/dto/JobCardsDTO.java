package zuvo_automotive.ZuvocloudAutomotive.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobCardsDTO {

    private int id;
    private int tenantId;
    private int customerId;
    private int vehicleId;
    private int status;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
