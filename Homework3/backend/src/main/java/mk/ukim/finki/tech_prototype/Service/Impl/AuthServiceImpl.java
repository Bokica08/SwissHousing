package mk.ukim.finki.tech_prototype.Service.Impl;

import mk.ukim.finki.tech_prototype.Configuration.JwtUtil;
import mk.ukim.finki.tech_prototype.Model.DTO.AuthResponse;
import mk.ukim.finki.tech_prototype.Model.DTO.LoginDTO;
import mk.ukim.finki.tech_prototype.Service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse authenticate(LoginDTO authRequest) throws Exception
    {
        //System.out.println(authRequest.getUsername() +"," + authRequest.getPassword() + "," + this.bCryptPasswordEncoder.encode(authRequest.getPassword()));
        System.out.println(authRequest);
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            //Here is the error
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        //this.logService.save(new Log(null, userDetails.getUsername(), jwt, null));
        System.out.println(jwt);
        return new AuthResponse(jwt);
    }
}
