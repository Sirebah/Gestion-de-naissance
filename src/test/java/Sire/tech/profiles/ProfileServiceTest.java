package Sire.tech.profiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {
    @Mock
    private ProfileRepository profileRepository;
    @InjectMocks
    private ProfileService profileService;

    @Test
    void shouldHaveProfiles() {
        // arrange
        when(profileRepository.findAll()).thenReturn(
            List.of(
                Profile.builder()
                    .email("bahsire1@gmail.com")
                    .lastName("Bah")
                    .phone("123456789")
                    .build()

            )
        );

        // action

        Set<ProfileDTO> profileList = this.profileService.findProfiles();

        //
        assertEquals(1, profileList.size());




    }
}