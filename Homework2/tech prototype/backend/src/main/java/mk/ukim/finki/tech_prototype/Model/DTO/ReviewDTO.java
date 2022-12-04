package mk.ukim.finki.tech_prototype.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.tech_prototype.Model.Location;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private String text;
    private String reviewerName;
    private String reviewerSurname;
    private Location location;
}
