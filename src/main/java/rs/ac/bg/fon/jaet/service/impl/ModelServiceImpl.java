package rs.ac.bg.fon.jaet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.jaet.exception.ModelDoesNotExistException;
import rs.ac.bg.fon.jaet.model.Model;
import rs.ac.bg.fon.jaet.repository.ModelRepository;
import rs.ac.bg.fon.jaet.service.ModelService;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Model create(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model findById(Long modelId) {
        Optional<Model> optionalModel = modelRepository.findById(modelId);

        if (optionalModel.isEmpty()) {
            throw new ModelDoesNotExistException("Model with given id doesn't exist.");
        }

        return optionalModel.get();
    }

    @Override
    public Model update(Model model, Long modelId) {
        Optional<Model> optionalModel = modelRepository.findById(modelId);

        if (optionalModel.isEmpty()) {
            throw new ModelDoesNotExistException("Model with given id doesn't exist.");
        }

        model.setId(optionalModel.get().getId());
        return modelRepository.save(model);
    }

    @Override
    public void deleteById(Long modelId) {
        modelRepository.deleteById(modelId);
    }

}
