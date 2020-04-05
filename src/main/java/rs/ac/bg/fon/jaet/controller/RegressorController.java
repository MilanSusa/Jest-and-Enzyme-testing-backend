package rs.ac.bg.fon.jaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.jaet.controller.wrapper.Response;
import rs.ac.bg.fon.jaet.dto.RegressorDto;
import rs.ac.bg.fon.jaet.model.Regressor;
import rs.ac.bg.fon.jaet.service.RegressorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class RegressorController {

    @Autowired
    private RegressorService regressorService;

    @PostMapping("regressors")
    public Response<RegressorDto> create(@RequestBody Regressor regressor) {
        return new Response<>(new RegressorDto(regressorService.create(regressor)));
    }

    @GetMapping("regressors")
    public Response<List<RegressorDto>> findAll() {
        return new Response<>(regressorService.findAll().stream()
                .map(RegressorDto::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("regressors/{regressorId}")
    public Response<RegressorDto> findById(@PathVariable Long regressorId) {
        return new Response<>(new RegressorDto(regressorService.findById(regressorId)));
    }

    @PutMapping("regressors/{regressorId}")
    public Response<RegressorDto> update(@RequestBody Regressor regressor,
                                         @PathVariable Long regressorId) {
        return new Response<>(new RegressorDto(regressorService.update(regressor, regressorId)));
    }

    @DeleteMapping("regressors/{regressorId}")
    public void deleteById(@PathVariable Long regressorId) {
        regressorService.deleteById(regressorId);
    }

}
