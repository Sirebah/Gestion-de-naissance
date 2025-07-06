package Sire.tech.security.activations;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationsRepository extends JpaRepository<Activations, Integer> {

    List<Activations> findAllByActiveAndDesactivationAfter(boolean active, LocalDateTime desactivation);
}
