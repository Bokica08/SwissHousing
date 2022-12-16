package mk.ukim.finki.tech_prototype.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
