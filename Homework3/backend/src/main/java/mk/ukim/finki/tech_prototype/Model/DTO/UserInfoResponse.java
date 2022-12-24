package mk.ukim.finki.tech_prototype.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private String firstname;
    private String lastname;
    private String username;
    private List<String> roles;
}
