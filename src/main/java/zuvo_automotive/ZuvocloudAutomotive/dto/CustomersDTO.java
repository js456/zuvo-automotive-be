package zuvo_automotive.ZuvocloudAutomotive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zuvo_automotive.ZuvocloudAutomotive.entity.Tenants;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDTO {
    private int id;
    private  int tenantId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime createdAt;
}
