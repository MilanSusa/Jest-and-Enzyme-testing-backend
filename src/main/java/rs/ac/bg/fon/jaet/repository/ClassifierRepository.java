package rs.ac.bg.fon.jaet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.jaet.model.Classifier;

@Repository
public interface ClassifierRepository extends JpaRepository<Classifier, Long> {
}
