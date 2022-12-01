package mk.ukim.finki.tech_prototype.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    @Column(length = 40000, nullable = false)
    @NotNull(message = "The review must have a content")
    @NotEmpty(message = "The review must have a content")
    private String text;
    @Column(nullable = false)
    private LocalDateTime timeCrated;
    @Column(nullable = false)
    private String reviewerName;
    @Column(nullable = false)

    private String reviewerSurname;
    @ManyToOne
    private Location location;
    public Review(String text, String reviewerName, String reviewerSurname, Location location) {
        this.text = text;
        this.reviewerName = reviewerName;
        this.reviewerSurname = reviewerSurname;
        this.timeCrated=LocalDateTime.now();
        this.location=location;
    }

}
