package mk.ukim.finki.MainService.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Location {
    private Long locationId;
    @NotNull(message = "The location must have coordinates")
    private Double x;
    @NotNull(message = "The location must have coordinates")
    private Double y;
    @NotNull(message = "The location must have a name")
    @NotEmpty(message = "The location must have a name")
    private String name;
    @NotNull(message = "The location must have a valid address")
    @NotEmpty(message = "The location must have a valid address")
    private String city;
    @NotNull(message = "The location must have a valid address")
    @NotEmpty(message = "The location must have a valid address")
    private String street;
    @NotNull(message = "The location must have a valid address")
    @NotEmpty(message = "The location must have a valid address")
    private String houseNumber;
    private String description;
    private String imagePath;
    public Location(Double x, Double y, String name, String city, String street, String houseNumber) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }
}
