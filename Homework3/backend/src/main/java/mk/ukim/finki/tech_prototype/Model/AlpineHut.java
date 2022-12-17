package mk.ukim.finki.tech_prototype.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AlpineHut extends Location {
    @Column(nullable = false)
    @NotNull(message = "The location must have info about the altitude")
    @Min(0)
    private int elevation;
    public AlpineHut(Double x, Double y, String name, String city, String street, String houseNumber, int elevation) {
        super(x, y, name, city, street, houseNumber);
        this.elevation=elevation;
    }
}
