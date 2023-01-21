package mk.ukim.finki.tech_prototype.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListReviewsDTO {
    private String text;
    private int grade;
    private LocalDateTime timeCreated;
    private String reviewerUsername;
    private Long reviewId;
}
