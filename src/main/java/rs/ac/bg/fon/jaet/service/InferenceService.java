package rs.ac.bg.fon.jaet.service;

import rs.ac.bg.fon.jaet.model.Inference;

import java.util.List;

public interface InferenceService {

    Inference create(Inference inference, Long modelId, Long personId);

    List<Inference> findAll();

    Inference findByIdAndModelIdAndPersonId(Long inferenceId, Long modelId, Long personId);

    Inference update(Inference inference, Long inferenceId, Long modelId, Long personId);

    void deleteById(Long inferenceId, Long modelId, Long personId);

}
