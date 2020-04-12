package rs.ac.bg.fon.jaet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.jaet.exception.InferenceDoesNotExistException;
import rs.ac.bg.fon.jaet.exception.ModelDoesNotExistException;
import rs.ac.bg.fon.jaet.exception.PersonDoesNotExistException;
import rs.ac.bg.fon.jaet.model.Inference;
import rs.ac.bg.fon.jaet.model.Model;
import rs.ac.bg.fon.jaet.model.Person;
import rs.ac.bg.fon.jaet.model.compositekey.InferenceKey;
import rs.ac.bg.fon.jaet.repository.InferenceRepository;
import rs.ac.bg.fon.jaet.repository.ModelRepository;
import rs.ac.bg.fon.jaet.repository.PersonRepository;
import rs.ac.bg.fon.jaet.service.InferenceService;

import java.util.List;
import java.util.Optional;

@Service
public class InferenceServiceImpl implements InferenceService {

    @Autowired
    private InferenceRepository inferenceRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Inference create(Inference inference, Long modelId, Long personId) {
        Optional<Model> optionalModel = modelRepository.findById(modelId);
        if (optionalModel.isEmpty()) {
            throw new ModelDoesNotExistException("Model with given id doesn't exist.");
        }

        Optional<Person> optionalPerson = personRepository.findById(personId);
        if (optionalPerson.isEmpty()) {
            throw new PersonDoesNotExistException("Person with given id doesn't exist.");
        }

        // Id will get auto incremented, Hibernate just needs a placeholder.
        inference.setId(-1L);
        inference.setModel(optionalModel.get());
        inference.setPerson(optionalPerson.get());
        return inferenceRepository.save(inference);
    }

    @Override
    public List<Inference> findAll() {
        return inferenceRepository.findAll();
    }

    @Override
    public Inference findByIdAndModelIdAndPersonId(Long inferenceId, Long modelId, Long personId) {
        Optional<Inference> optionalInference = inferenceRepository.findByIdAndModelIdAndPersonId(inferenceId, modelId, personId);

        if (optionalInference.isEmpty()) {
            throw new InferenceDoesNotExistException("Inference with given key doesn't exist.");
        }

        return optionalInference.get();
    }

    @Override
    public Inference update(Inference inference, Long inferenceId, Long modelId, Long personId) {
        Optional<Inference> optionalInference = inferenceRepository.findByIdAndModelIdAndPersonId(inferenceId, modelId, personId);

        if (optionalInference.isEmpty()) {
            throw new InferenceDoesNotExistException("Inference with given key doesn't exist.");
        }

        Optional<Model> optionalModel = modelRepository.findById(modelId);
        Optional<Person> optionalPerson = personRepository.findById(personId);

        inference.setId(optionalInference.get().getId());
        inference.setModel(optionalModel.get());
        inference.setPerson(optionalPerson.get());
        return inferenceRepository.save(inference);
    }

    @Override
    public void deleteById(Long inferenceId, Long modelId, Long personId) {
        Optional<Model> optionalModel = modelRepository.findById(modelId);
        if (optionalModel.isEmpty()) {
            throw new ModelDoesNotExistException("Model with given id doesn't exist.");
        }

        Optional<Person> optionalPerson = personRepository.findById(personId);
        if (optionalPerson.isEmpty()) {
            throw new PersonDoesNotExistException("Person with given id doesn't exist.");
        }

        InferenceKey inferenceKey = new InferenceKey(inferenceId, optionalPerson.get(), optionalModel.get());
        inferenceRepository.deleteById(inferenceKey);
    }

}
