package rs.ac.bg.fon.jaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.jaet.dto.InferenceDto;
import rs.ac.bg.fon.jaet.model.Inference;
import rs.ac.bg.fon.jaet.service.InferenceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class InferenceController {

    @Autowired
    private InferenceService inferenceService;

    @PostMapping("inferences/models/{modelId}/persons/{personId}")
    public InferenceDto create(@RequestBody Inference inference,
                               @PathVariable Long modelId,
                               @PathVariable Long personId) {
        return new InferenceDto(inferenceService.create(inference, modelId, personId));
    }

    @GetMapping("inferences")
    public List<InferenceDto> findAll() {
        return inferenceService.findAll().stream()
                .map(InferenceDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("inferences/{inferenceId}/models/{modelId}/persons/{personId}")
    public InferenceDto findByIdAndModelIdAndPersonId(@PathVariable Long inferenceId,
                                                      @PathVariable Long modelId,
                                                      @PathVariable Long personId) {
        return new InferenceDto(inferenceService.findByIdAndModelIdAndPersonId(inferenceId, modelId, personId));
    }

    @PutMapping("inferences/{inferenceId}/models/{modelId}/persons/{personId}")
    public InferenceDto update(@RequestBody Inference inference,
                               @PathVariable Long inferenceId,
                               @PathVariable Long modelId,
                               @PathVariable Long personId) {
        return new InferenceDto(inferenceService.update(inference, inferenceId, modelId, personId));
    }

    @DeleteMapping("inferences/{inferenceId}/models/{modelId}/persons/{personId}")
    public void deleteById(@PathVariable Long inferenceId,
                           @PathVariable Long modelId,
                           @PathVariable Long personId) {
        inferenceService.deleteById(inferenceId, modelId, personId);
    }

}
