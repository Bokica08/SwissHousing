package mk.ukim.finki.MainService.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Hotel extends Location{
    @NotNull(message = "The location must have a website")
    @NotEmpty(message = "The location must have a website")
    private String website;
    @NotNull(message = "The location must have a phone number")
    @NotEmpty(message = "The location must have a phone number")
    private String phoneNumber;
    @NotNull(message = "The location must have a valid number of stars")
    @Max(5)
    @Min(1)
    private int stars;

    public Hotel(Double x, Double y, String name, String city, String street, String houseNumber, String website, String phoneNumber, int stars) {
        super(x, y, name, city, street, houseNumber);
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.stars = stars;
    }
}
