package workout.fitness.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fit")
public class Fit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Ensures UUID is generated automatically
    private String id; // Change this to UUID type

    private String bmr;
    private String bmi;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
