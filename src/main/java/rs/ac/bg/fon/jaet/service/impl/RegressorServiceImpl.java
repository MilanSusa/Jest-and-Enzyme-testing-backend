package rs.ac.bg.fon.jaet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.jaet.exception.RegressorDoesNotExistException;
import rs.ac.bg.fon.jaet.model.Regressor;
import rs.ac.bg.fon.jaet.repository.RegressorRepository;
import rs.ac.bg.fon.jaet.service.RegressorService;

import java.util.List;
import java.util.Optional;

@Service
public class RegressorServiceImpl implements RegressorService {

    @Autowired
    private RegressorRepository regressorRepository;

    @Override
    public Regressor create(Regressor regressor) {
        return regressorRepository.save(regressor);
    }

    @Override
    public List<Regressor> findAll() {
        return regressorRepository.findAll();
    }

    @Override
    public Regressor findById(Long regressorId) {
        Optional<Regressor> optionalRegressor = regressorRepository.findById(regressorId);

        if (optionalRegressor.isEmpty()) {
            throw new RegressorDoesNotExistException("Regressor with given id doesn't exist.");
        }

        return optionalRegressor.get();
    }

    @Override
    public Regressor update(Regressor regressor, Long regressorId) {
        Optional<Regressor> optionalRegressor = regressorRepository.findById(regressorId);

        if (optionalRegressor.isEmpty()) {
            throw new RegressorDoesNotExistException("Regressor with given id doesn't exist.");
        }

        regressor.setId(optionalRegressor.get().getId());
        return regressorRepository.save(regressor);
    }

    @Override
    public void deleteById(Long regressorId) {
        regressorRepository.deleteById(regressorId);
    }

}
