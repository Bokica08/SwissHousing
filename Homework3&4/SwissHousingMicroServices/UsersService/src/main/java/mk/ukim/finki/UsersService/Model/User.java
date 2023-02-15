package mk.ukim.finki.UsersService.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.UsersService.Model.Enumeration.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name="users")
public class User implements UserDetails {
    @Id
    @NotNull(message = "The user must have an username")
    @NotEmpty(message = "The user must have an username")
    private String username;
    @Column(nullable = false)
    @NotNull(message = "The user must have an first name")
    @NotEmpty(message = "The user must have an first name")
    private String firstname;
    @Column(nullable = false)
    @NotNull(message = "The user must have an last name")
    @NotEmpty(message = "The user must have an last name")
    private String lastname;
    @Column(nullable = false)
    @NotNull(message = "The user must have an password")
    @NotEmpty(message = "The user must have an password")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "The user must have a role")
    private Role role;
    @ManyToMany
    private List<Location> favourites;
    @ManyToMany
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
