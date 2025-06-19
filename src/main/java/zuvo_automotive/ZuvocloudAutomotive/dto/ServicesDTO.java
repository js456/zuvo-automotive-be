package zuvo_automotive.ZuvocloudAutomotive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServicesDTO {
    private int id;
    private int tenantId;
    private String name;
    private String description;
    private double price;
    private double durationMinutes;
    private LocalDateTime createdAt;
}
