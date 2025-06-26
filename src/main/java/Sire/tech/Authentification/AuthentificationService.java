package Sire.tech.Authentification;

import Sire.tech.profiles.Profile;
import Sire.tech.profiles.ProfileDTO;
import Sire.tech.profiles.ProfileMapper;
import Sire.tech.profiles.ProfileRepository;
import Sire.tech.shared.services.ValidationsService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthentificationService {

    private final ValidationsService validationsService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public Profile create(ProfileDTO profileDTO) {

        Profile profile = this.profileMapper.dtoToEntity(profileDTO);

        this.validationsService.validateEmail(profile.getEmail());
        this.validationsService.validatePassword(profile.getPassword());
        this.validationsService.validatePhone(profile.getPhone());

        String userPassword = profile.getPassword();
        String passwordEncode = passwordEncoder.encode(userPassword);
        profile.setPassword(passwordEncode);

        return profileRepository.save(profile);
    }
}
