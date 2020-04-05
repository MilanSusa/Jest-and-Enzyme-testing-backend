package rs.ac.bg.fon.jaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.jaet.controller.wrapper.Response;
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
    public Response<InferenceDto> create(@RequestBody Inference inference,
                                         @PathVariable Long modelId,
                                         @PathVariable Long personId) {
        return new Response<>(new InferenceDto(inferenceService.create(inference, modelId, personId)));
    }

    @GetMapping("inferences")
    public Response<List<InferenceDto>> findAll() {
        return new Response<>(inferenceService.findAll().stream()
                .map(InferenceDto::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("inferences/{inferenceId}/models/{modelId}/persons/{personId}")
    public Response<InferenceDto> findByIdAndModelIdAndPersonId(@PathVariable Long inferenceId,
                                                                @PathVariable Long modelId,
                                                                @PathVariable Long personId) {
        return new Response<>(new InferenceDto(inferenceService.findByIdAndModelIdAndPersonId(inferenceId, modelId, personId)));
    }

    @PutMapping("inferences/{inferenceId}/models/{modelId}/persons/{personId}")
    public Response<InferenceDto> update(@RequestBody Inference inference,
                                         @PathVariable Long inferenceId,
                                         @PathVariable Long modelId,
                                         @PathVariable Long personId) {
        return new Response<>(new InferenceDto(inferenceService.update(inference, inferenceId, modelId, personId)));
    }

    @DeleteMapping("inferences/{inferenceId}/models/{modelId}/persons/{personId}")
    public void deleteById(@PathVariable Long inferenceId,
                           @PathVariable Long modelId,
                           @PathVariable Long personId) {
        inferenceService.deleteById(inferenceId, modelId, personId);
    }

}
