package mk.ukim.finki.tech_prototype.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class CampSite extends Location {
    @Column(nullable = false)
    @NotNull(message = "The location must have a website")
    @NotEmpty(message = "The location must have a website")
    private String website;
    @Column(nullable = false)
    @NotNull(message = "The location must have a phone number")
    @NotEmpty(message = "The location must have a phone number")
    private String phoneNumber;

    public CampSite(Double x, Double y, String name, String city, String street, String houseNumber, String website, String phoneNumber) {
        super(x, y, name, city, street, houseNumber);
        this.website = website;
        this.phoneNumber = phoneNumber;
    }
}
