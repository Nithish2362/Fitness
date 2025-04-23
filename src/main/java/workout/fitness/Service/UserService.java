package workout.fitness.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workout.fitness.Model.User;
import workout.fitness.Repo.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to save a user
    public User createUser(User user) {
        return userRepository.save(user);  // Assuming you have a UserRepository that extends JpaRepository
    }

    // Method to get all users
    public List<User> findAll() {
        return userRepository.findAll();  // Fetching all users
    }
}
