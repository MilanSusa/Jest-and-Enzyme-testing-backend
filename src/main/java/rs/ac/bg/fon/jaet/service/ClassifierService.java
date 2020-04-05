package rs.ac.bg.fon.jaet.service;

import rs.ac.bg.fon.jaet.model.Classifier;

import java.util.List;

public interface ClassifierService {

    Classifier create(Classifier classifier);

    List<Classifier> findAll();

    Classifier findById(Long classifierId);

    Classifier update(Classifier classifier, Long classifierId);

    void deleteById(Long classifierId);

}
