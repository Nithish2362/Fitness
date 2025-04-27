package workout.fitness.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import workout.fitness.Model.Tdee;
import workout.fitness.Service.TdeeService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/tdee")
public class TdeeController {

    private final TdeeService tdeeService;

    @PostMapping
    public Tdee createTdee(@RequestBody Tdee tdee) {
        return tdeeService.createTdee(tdee);
    }

    @RequestMapping("/all")
    public List<Tdee> getAll() {
        return tdeeService.findAll();
    }

}