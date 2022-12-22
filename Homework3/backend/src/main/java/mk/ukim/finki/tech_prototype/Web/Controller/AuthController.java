package mk.ukim.finki.tech_prototype.Web.Controller;

import mk.ukim.finki.tech_prototype.Model.DTO.AuthResponse;
import mk.ukim.finki.tech_prototype.Model.DTO.LoginDTO;
import mk.ukim.finki.tech_prototype.Service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService service) {
        this.authService = service;
    }

    @RequestMapping(
            value = {"authenticate", "/authenticate"},
            method = RequestMethod.POST,
            consumes = {
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.TEXT_PLAIN_VALUE
            },
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody AuthResponse login(LoginDTO authRequest) throws Exception
    {
        return this.authService.authenticate(authRequest);
    }
}
