package mk.ukim.finki.MainService.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CampSite extends Location {
    @NotNull(message = "The location must have a website")
    @NotEmpty(message = "The location must have a website")
    private String website;
    @NotNull(message = "The location must have a phone number")
    @NotEmpty(message = "The location must have a phone number")
    private String phoneNumber;

    public CampSite(Double x, Double y, String name, String city, String street, String houseNumber, String website, String phoneNumber) {
        super(x, y, name, city, street, houseNumber);
        this.website = website;
        this.phoneNumber = phoneNumber;
    }
}
