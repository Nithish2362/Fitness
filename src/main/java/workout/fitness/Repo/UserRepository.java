package workout.fitness.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import workout.fitness.Model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
