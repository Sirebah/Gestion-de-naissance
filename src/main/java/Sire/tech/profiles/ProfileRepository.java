package Sire.tech.profiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
}
