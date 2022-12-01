package mk.ukim.finki.tech_prototype.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AlpineHut extends Location {
    public AlpineHut(Double x, Double y, String name, String city, String street, String houseNumber) {
        super(x, y, name, city, street, houseNumber);
    }
}
