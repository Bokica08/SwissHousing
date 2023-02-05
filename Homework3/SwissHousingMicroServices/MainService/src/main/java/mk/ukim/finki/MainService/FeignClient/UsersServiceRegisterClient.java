package mk.ukim.finki.MainService.FeignClient;

import mk.ukim.finki.MainService.Model.DTO.UserDTO;
import mk.ukim.finki.MainService.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="usersServiceRegister", url="localhost:8180")
public interface UsersServiceRegisterClient {
    @PostMapping("/register")
    ResponseEntity<User> register(@RequestBody UserDTO userDto);
}
