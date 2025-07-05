package Sire.tech.security.activations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationsRepository extends JpaRepository<Activations, Integer> {
}
