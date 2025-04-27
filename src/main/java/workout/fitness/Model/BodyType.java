package workout.fitness.Model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BodyType")
public class BodyType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String type;
}