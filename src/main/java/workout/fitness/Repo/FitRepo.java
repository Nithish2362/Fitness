package workout.fitness.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import workout.fitness.Model.Fit;

@Repository
public interface FitRepo extends JpaRepository<Fit, String> {


    
}
