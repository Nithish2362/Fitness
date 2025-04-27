package workout.fitness.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import workout.fitness.Model.BodyType;

@Repository
public interface BodyTypeRepo extends JpaRepository<BodyType, String> {

    @Query("SELECT u FROM BodyType u WHERE u.type = :bodyType")
     BodyType findByType(String bodyType);
}
