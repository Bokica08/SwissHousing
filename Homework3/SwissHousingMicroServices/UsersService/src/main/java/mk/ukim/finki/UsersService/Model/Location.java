package mk.ukim.finki.UsersService.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Location {
    @Id
    private Long locationId;

    public Location(Long locationId) {
        this.locationId = locationId;
    }
}
