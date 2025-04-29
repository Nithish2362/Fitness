package workout.fitness.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import workout.fitness.Model.BodyType;
import workout.fitness.Service.BodyTypeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bodytype")
public class BodyTypeController {

    private final BodyTypeService bodyTypeService;

    @PostMapping
    public BodyType createBodyType(@RequestBody BodyType type) {
        return bodyTypeService.createBodyType(type);
    }

    @RequestMapping("/all")
    public List<BodyType> getAll() {
        return bodyTypeService.findAll();
    }

}