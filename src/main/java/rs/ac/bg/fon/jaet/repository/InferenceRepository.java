package rs.ac.bg.fon.jaet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.jaet.model.Inference;
import rs.ac.bg.fon.jaet.model.compositekey.InferenceId;

@Repository
public interface InferenceRepository extends JpaRepository<Inference, InferenceId> {
}
