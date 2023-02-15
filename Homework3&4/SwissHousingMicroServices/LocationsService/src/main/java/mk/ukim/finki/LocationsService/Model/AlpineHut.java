package mk.ukim.finki.LocationsService.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
