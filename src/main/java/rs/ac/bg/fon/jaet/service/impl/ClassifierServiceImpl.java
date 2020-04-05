package rs.ac.bg.fon.jaet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.jaet.exception.ClassifierDoesNotExistException;
import rs.ac.bg.fon.jaet.model.Classifier;
import rs.ac.bg.fon.jaet.repository.ClassifierRepository;
import rs.ac.bg.fon.jaet.service.ClassifierService;

import java.util.List;
import java.util.Optional;

@Service
public class ClassifierServiceImpl implements ClassifierService {

    @Autowired
    private ClassifierRepository classifierRepository;

    @Override
    public Classifier create(Classifier classifier) {
        return classifierRepository.save(classifier);
    }

    @Override
    public List<Classifier> findAll() {
        return classifierRepository.findAll();
    }

    @Override
    public Classifier findById(Long classifierId) {
        Optional<Classifier> optionalClassifier = classifierRepository.findById(classifierId);

        if (optionalClassifier.isEmpty()) {
            throw new ClassifierDoesNotExistException("Classifier with given id doesn't exist.");
        }

        return optionalClassifier.get();
    }

    @Override
    public Classifier update(Classifier classifier, Long classifierId) {
        Optional<Classifier> optionalClassifier = classifierRepository.findById(classifierId);

        if (optionalClassifier.isEmpty()) {
            throw new ClassifierDoesNotExistException("Classifier with given id doesn't exist.");
        }

        classifier.setId(optionalClassifier.get().getId());
        return classifierRepository.save(classifier);
    }

    @Override
    public void deleteById(Long classifierId) {
        classifierRepository.deleteById(classifierId);
    }

}
