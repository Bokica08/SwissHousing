package mk.ukim.finki.MainService.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private String firstname;
    private String lastname;
    private String username;
    private List<String> roles;
}
