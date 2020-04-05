package rs.ac.bg.fon.jaet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.jaet.model.Regressor;

@Repository
public interface RegressorRepository extends JpaRepository<Regressor, Long> {
}
