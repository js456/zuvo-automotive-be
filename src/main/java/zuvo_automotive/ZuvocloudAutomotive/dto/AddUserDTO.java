package zuvo_automotive.ZuvocloudAutomotive.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddUserDTO {

    private int tenantId;
    private String name;
    private  String email;
    private String phone;
    private int passwordHash;
    private String role;

}
