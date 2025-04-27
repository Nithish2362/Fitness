package workout.fitness.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import workout.fitness.Model.Tdee;

@Repository
public interface TdeeRepo extends JpaRepository<Tdee, String> {
    @Query("SELECT t FROM Tdee t WHERE t.activityName = :activityName")
    Tdee findByActivityName(String activityName);

    
}
