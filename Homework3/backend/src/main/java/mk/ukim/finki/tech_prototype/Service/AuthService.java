package mk.ukim.finki.tech_prototype.Service;

import mk.ukim.finki.tech_prototype.Model.DTO.AuthResponse;
import mk.ukim.finki.tech_prototype.Model.DTO.LoginDTO;

public interface AuthService {
    public AuthResponse authenticate(LoginDTO authRequest) throws Exception;

}

