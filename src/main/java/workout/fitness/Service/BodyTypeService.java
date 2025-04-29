package workout.fitness.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workout.fitness.Model.BodyType;
import workout.fitness.Model.User;
import workout.fitness.Repo.BodyTypeRepo;

@Service
public class BodyTypeService {
  @Autowired
  private BodyTypeRepo BodyTypeRepo;

  public BodyType createBodyType(BodyType bodyType) {
    BodyType existingUser = BodyTypeRepo.findByType(bodyType.getType());
    if (existingUser != null) {
      throw new RuntimeException("BodyType " + bodyType.getType() + " already exists");
    }
    return BodyTypeRepo.save(bodyType);

  }

  public List<BodyType> findAll() {
    return BodyTypeRepo.findAll();
  }
}
