package rs.ac.bg.fon.jaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.jaet.controller.wrapper.Response;
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
    public Response<ModelDto> create(@RequestBody Model model) {
        return new Response<>(new ModelDto(modelService.create(model)));
    }

    @GetMapping("models")
    public Response<List<ModelDto>> findAll() {
        return new Response<>(modelService.findAll().stream()
                .map(ModelDto::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("models/{modelId}")
    public Response<ModelDto> findById(@PathVariable Long modelId) {
        return new Response<>(new ModelDto(modelService.findById(modelId)));
    }

    @PutMapping("models/{modelId}")
    public Response<ModelDto> update(@RequestBody Model model,
                                     @PathVariable Long modelId) {
        return new Response<>(new ModelDto(modelService.update(model, modelId)));
    }

    @DeleteMapping("models/{modelId}")
    public void deleteById(@PathVariable Long modelId) {
        modelService.deleteById(modelId);
    }

}
