package workout.fitness.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import workout.fitness.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    User findByuserName(String userName); // Cleaner and works perfectly

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);
}
