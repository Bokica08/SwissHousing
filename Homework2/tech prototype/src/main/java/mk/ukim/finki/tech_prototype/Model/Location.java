package mk.ukim.finki.tech_prototype.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Data
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    @Column(nullable = false)
    @NotNull(message = "The location must have coordinates")
    private Double x;
    @Column(nullable = false)
    @NotNull(message = "The location must have coordinates")
    private Double y;
    @NotNull(message = "The location must have a name")
    @NotEmpty(message = "The location must have a name")
    @Column(nullable = false)
    private String name;
    @NotNull(message = "The location must have a valid address")
    @NotEmpty(message = "The location must have a valid address")
    @Column(nullable = false)
    private String city;
    @NotNull(message = "The location must have a valid address")
    @NotEmpty(message = "The location must have a valid address")
    @Column(nullable = false)
    private String street;
    @NotNull(message = "The location must have a valid address")
    @NotEmpty(message = "The location must have a valid address")
    @Column(nullable = false)
    private String houseNumber;
    @Column(length = 40000)
    private String description;
    private String imagePath;
    private Double rating;
    private int numOfRatings;
    /*@OneToMany(mappedBy = "location")
    @JoinColumn(name = "reviewId")
    private List<Review> reviews;*/
    public Location(Double x, Double y, String name, String city, String street, String houseNumber) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.rating= (double) 0;
        this.numOfRatings=0;
    }
}
