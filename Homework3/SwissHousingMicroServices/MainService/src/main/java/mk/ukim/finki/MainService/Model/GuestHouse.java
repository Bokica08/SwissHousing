package mk.ukim.finki.MainService.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class GuestHouse extends Location{
    @NotNull(message = "The location must have a phone number")
    @NotEmpty(message = "The location must have a phone number")
    private String phoneNumber;

    public GuestHouse(Double x, Double y, String name, String city, String street, String houseNumber, String phoneNumber) {
        super(x, y, name, city, street, houseNumber);
        this.phoneNumber = phoneNumber;
    }
}
