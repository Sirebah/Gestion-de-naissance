package Sire.tech.profiles;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// POur faire le test unitaire de notre repository il faut les annotations suivantes @DataJpaTest @AutoConfigureTestDatabase
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProfileRepositoryTest {

    @Autowired
    private ProfileRepository profileRepository;



    void shoudHaveAllProfile() {
        // Arrange
        Profile profile1 = Profile.builder()
            .lastName("Sire")
            .firstName("Bah")
            .email("bahsire1@gmail.com")
            .build();

        Profile profile2 = Profile.builder()
            .lastName("Moussa")
            .firstName("Diallo")
            .email("diallo@mail.test")
            .build();

        this.profileRepository.saveAll(List.of(profile1, profile2));

        // action

        List<Profile> profiles = this.profileRepository.findAll();
        // assert

        Assertions.assertEquals(2, profiles.size());



    }

}
