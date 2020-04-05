package rs.ac.bg.fon.jaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.jaet.controller.wrapper.Response;
import rs.ac.bg.fon.jaet.dto.ClassifierDto;
import rs.ac.bg.fon.jaet.model.Classifier;
import rs.ac.bg.fon.jaet.service.ClassifierService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class ClassifierController {

    @Autowired
    private ClassifierService classifierService;

    @PostMapping("classifiers")
    public Response<ClassifierDto> create(@RequestBody Classifier classifier) {
        return new Response<>(new ClassifierDto(classifierService.create(classifier)));
    }

    @GetMapping("classifiers")
    public Response<List<ClassifierDto>> findAll() {
        return new Response<>(classifierService.findAll().stream()
                .map(ClassifierDto::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("classifiers/{classifierId}")
    public Response<ClassifierDto> findById(@PathVariable Long classifierId) {
        return new Response<>(new ClassifierDto(classifierService.findById(classifierId)));
    }

    @PutMapping("classifiers/{classifierId}")
    public Response<ClassifierDto> update(@RequestBody Classifier classifier,
                                          @PathVariable Long classifierId) {
        return new Response<>(new ClassifierDto(classifierService.update(classifier, classifierId)));
    }

    @DeleteMapping("classifiers/{classifierId}")
    public void deleteById(@PathVariable Long classifierId) {
        classifierService.deleteById(classifierId);
    }

}
