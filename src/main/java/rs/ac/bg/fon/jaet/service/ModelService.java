package rs.ac.bg.fon.jaet.service;

import rs.ac.bg.fon.jaet.model.Model;

import java.util.List;

public interface ModelService {

    Model create(Model model);

    List<Model> findAll();

    Model findById(Long modelId);

    Model update(Model model, Long modelId);

    void deleteById(Long modelId);

}
