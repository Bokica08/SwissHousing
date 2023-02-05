package mk.ukim.finki.MainService.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.MainService.Configuration.CustomAuthorityDeserializer;
import mk.ukim.finki.MainService.Model.Enumeration.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class User implements UserDetails {
    @NotNull(message = "The user must have an username")
    @NotEmpty(message = "The user must have an username")
    private String username;
    @NotNull(message = "The user must have an first name")
    @NotEmpty(message = "The user must have an first name")
    private String firstname;
    @NotNull(message = "The user must have an last name")
    @NotEmpty(message = "The user must have an last name")
    private String lastname;
    @NotNull(message = "The user must have an password")
    @NotEmpty(message = "The user must have an password")
    private String password;
    @NotNull(message = "The user must have a role")
    private Role role;
    private List<Location> favourites;
    private List<Location> visited;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired =  true;
    private boolean isEnabled = true;

    public User(String username, String firstname, String lastname, String password, Role role) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        visited=new ArrayList<>();
        favourites=new ArrayList<>();
    }

    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
