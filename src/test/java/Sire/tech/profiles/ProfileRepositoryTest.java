package Sire.tech.profiles;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    @BeforeEach
    void setUP() {
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

    }

    @AfterEach
    void tearDown() {
        this.profileRepository.deleteAll();
    }



    void shoudHaveAllProfile() {
        // Arrange
       // ici j'ai coupé la partie pour ajouter au niveau de @BeforeEach dans la méthode setUp(); pour pouvoir construire ces données
        // à fois qu'on éffectue les tests

        // action

        List<Profile> profiles = this.profileRepository.findAll();
        // assert

        Assertions.assertEquals(2, profiles.size());

    }

    @Test
    void findProfileByEmail() {
        // arrange

        // action

        Optional<Profile> profile = this.profileRepository.findByEmail("bahsire1@gmail.com");



        // assert

        Assertions.assertTrue(profile.isPresent());
    }

    void findBymailIsEmpty() {
        //arange

        // act
        Optional<Profile> profile = this.profileRepository.findByEmail("notPresent@gmai.com");

        // assert

        Assertions.assertTrue(profile.isEmpty());

    }

}
