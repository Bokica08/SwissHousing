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
    @ManyToOne
    private User reviewer;
    @ManyToOne
    private Location location;
    @NotNull(message = "The review must have a grade")
    private int grade;
    public Review(String text, User reviewer, Location location, int grade) {
        this.text = text;
        this.reviewer=reviewer;
        this.timeCrated=LocalDateTime.now();
        this.location=location;
    }

}
