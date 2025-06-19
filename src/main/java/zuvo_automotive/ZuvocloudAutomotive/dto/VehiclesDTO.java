package zuvo_automotive.ZuvocloudAutomotive.dto;

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
public class VehiclesDTO {
    private int id;
    private int customerId;
    private String make;
    private String model;
    private Year year;
    private String licensePlate;
    private int  vin;
    private LocalDateTime createdAt;
}
