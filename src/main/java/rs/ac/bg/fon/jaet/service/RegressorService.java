package rs.ac.bg.fon.jaet.service;

import rs.ac.bg.fon.jaet.model.Regressor;

import java.util.List;

public interface RegressorService {

    Regressor create(Regressor regressor);

    List<Regressor> findAll();

    Regressor findById(Long regressorId);

    Regressor update(Regressor regressor, Long regressorId);

    void deleteById(Long regressorId);

}
