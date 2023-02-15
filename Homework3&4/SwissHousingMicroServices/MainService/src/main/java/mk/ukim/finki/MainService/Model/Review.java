package mk.ukim.finki.MainService.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Review {
    private Long reviewId;
    @NotNull(message = "The review must have a content")
    @NotEmpty(message = "The review must have a content")
    private String text;
    private LocalDateTime timeCrated;
    private User reviewer;
    private Location location;
    @NotNull(message = "The review must have a grade")
    private int grade;
    public Review(String text, User reviewer, Location location, int grade) {
        this.text = text;
        this.reviewer=reviewer;
        this.timeCrated=LocalDateTime.now();
        this.location=location;
        this.grade=grade;
    }

}
