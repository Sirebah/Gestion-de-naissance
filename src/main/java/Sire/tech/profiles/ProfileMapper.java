package Sire.tech.profiles;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public Profile dtoToEntity(ProfileDTO profileDTO) {

        Profile profile = new Profile();

        profile.setFirstName(profileDTO.firstName());
        profile.setLastName(profileDTO.lastName());
        profile.setEmail(profileDTO.email());
        profile.setPassword(profileDTO.password());
        profile.setCivility(profileDTO.civility());
        profile.setPhone(profileDTO.phone());

        return profile;
    }

    public ProfileDTO entityToDto(Profile profile) {
        return new ProfileDTO(
            profile.getFirstName(),
            profile.getLastName(),
            profile.getCivility(),
            profile.getEmail(),
            profile.getPhone(),
            null

        );
    }


}
