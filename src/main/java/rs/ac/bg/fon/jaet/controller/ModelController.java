package rs.ac.bg.fon.jaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.jaet.dto.ModelDto;
import rs.ac.bg.fon.jaet.model.Model;
import rs.ac.bg.fon.jaet.service.ModelService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("models")
    public ModelDto create(@RequestBody Model model) {
        return new ModelDto(modelService.create(model));
    }

    @GetMapping("models")
    public List<ModelDto> findAll() {
        return modelService.findAll().stream()
                .map(ModelDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("models/{modelId}")
    public ModelDto findById(@PathVariable Long modelId) {
        return new ModelDto(modelService.findById(modelId));
    }

    @PutMapping("models/{modelId}")
    public ModelDto update(@RequestBody Model model,
                           @PathVariable Long modelId) {
        return new ModelDto(modelService.update(model, modelId));
    }

    @DeleteMapping("models/{modelId}")
    public void deleteById(@PathVariable Long modelId) {
        modelService.deleteById(modelId);
    }

}
