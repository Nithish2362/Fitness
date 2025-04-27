package workout.fitness.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workout.fitness.Model.Tdee;
import workout.fitness.Repo.TdeeRepo;

@Service
public class TdeeService {

    @Autowired
    private TdeeRepo tdeeRepo;

    public Tdee createTdee(Tdee tdee) {
        Tdee existingUser = tdeeRepo.findByActivityName(tdee.getActivityName());

        if (existingUser != null) {
            throw new RuntimeException("Tdee with ActivityName " + tdee.getActivityName() + " already exists");
        }
        return tdeeRepo.save(tdee);
    }

    public List<Tdee> findAll() {
        return tdeeRepo.findAll();
    }
}
