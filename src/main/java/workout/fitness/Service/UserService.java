package workout.fitness.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workout.fitness.Model.Fit;
import workout.fitness.Model.User;
import workout.fitness.Repo.FitRepo;
import workout.fitness.Repo.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FitRepo fitRepo;

    public User createUser(User user) {
        User existingUser = userRepository.findByuserName(user.getUserName());
        User nk = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            throw new RuntimeException(
                    "User with username " + user.getUserName() + " already exists with different ID");
        }
        if (nk != null) {
            throw new RuntimeException(
                    "User with email " + user.getEmail() + " already exists with different ID");
        }

        // Save the user first
        User savedUser = userRepository.save(user);

        // After saving the user, calculate and save BMI and BMR
        calculateBmiAndBmr(savedUser);

        return savedUser;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Method to calculate and save BMI and BMR for the user
    private void calculateBmiAndBmr(User user) {
        try {
            // Convert height, weight, and age to numeric values
            Double height = parseDouble(user.getHeight());
            Double weight = parseDouble(user.getWeight());
            Integer age = parseInteger(user.getAge());

            if (height == null || weight == null || age == null || height == 0 || weight == 0) {
                System.out.println("Invalid data for user: " + user.getId() + ", skipping BMI/BMR calculation.");
                return;
            }

            // Calculate BMI and BMR
            double heightInMeters = height / 100.0; // Convert height from cm to meters
            double bmi = weight / (heightInMeters * heightInMeters); // BMI formula
            double bmr = 10 * weight + 6.25 * height - 5 * age + 5; // Mifflin-St Jeor BMR formula (for men)

            // Create and save Fit entity with BMI and BMR values
            Fit fit = new Fit();
            fit.setBmi(String.format("%.2f", bmi)); // Format to 2 decimal places
            fit.setBmr(String.format("%.2f", bmr)); // Format to 2 decimal places
            fit.setUser(user);

            fitRepo.save(fit); // Save the Fit entity with the calculated values

        } catch (Exception e) {
            System.out.println("Error calculating BMI/BMR for user: " + user.getId());
            e.printStackTrace();
        }
    }

    // Helper method to safely parse String to Double
    private Double parseDouble(String value) {
        try {
            return value != null && !value.isEmpty() ? Double.parseDouble(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Helper method to safely parse String to Integer
    private Integer parseInteger(String value) {
        try {
            return value != null && !value.isEmpty() ? Integer.parseInt(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}