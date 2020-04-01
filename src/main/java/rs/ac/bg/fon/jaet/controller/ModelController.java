package rs.ac.bg.fon.jaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.jaet.model.Model;
import rs.ac.bg.fon.jaet.service.ModelService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("models")
    public Model create(@RequestBody Model model) {
        return modelService.create(model);
    }

    @GetMapping("models")
    public List<Model> findAll() {
        return modelService.findAll();
    }

    @GetMapping("models/{modelId}")
    public Model findById(@PathVariable Long modelId) {
        return modelService.findById(modelId);
    }

    @PutMapping("models/{modelId}")
    public Model update(@RequestBody Model model,
                        @PathVariable Long modelId) {
        return modelService.update(model, modelId);
    }

    @DeleteMapping("models/{modelId}")
    public void deleteById(@PathVariable Long modelId) {
        modelService.deleteById(modelId);
    }

}
