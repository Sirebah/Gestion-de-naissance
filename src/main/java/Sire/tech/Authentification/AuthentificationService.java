package Sire.tech.Authentification;

import java.util.Map;

import Sire.tech.notifications.EmailsService;
import Sire.tech.profiles.Profile;
import Sire.tech.profiles.ProfileDTO;
import Sire.tech.profiles.ProfileMapper;
import Sire.tech.profiles.ProfileRepository;
import Sire.tech.profiles.ProfileService;
import Sire.tech.profiles.Role;
import Sire.tech.profiles.RolesRepository;
import Sire.tech.security.activations.Activations;
import Sire.tech.security.activations.ActivationsService;
import Sire.tech.shared.services.ValidationsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class AuthentificationService {

    private final ValidationsService validationsService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ProfileRepository profileRepository;
    private final RolesRepository rolesRepository;
    private final EmailsService  emailsService;
    private final ProfileMapper profileMapper;
    private final ActivationsService activationsService;


    public Profile create(ProfileDTO profileDTO) {

        Profile profile = this.profileMapper.dtoToEntity(profileDTO);

        this.validationsService.validateEmail(profile.getEmail());
        this.validationsService.validatePassword(profile.getPassword());
        this.validationsService.validatePhone(profile.getPhone());

        String userPassword = profile.getPassword();
        String passwordEncode = passwordEncoder.encode(userPassword);
        profile.setPassword(passwordEncode);

        Role role = this.rolesRepository.findByName("PUBLIC");

        profile.setRole(role);

        Profile thisprofile = profileRepository.save(profile);

        Activations activation = activationsService.create(thisprofile);

        //log.info("Le mail de l'utilisateur {} et le code activation est  {}", profile.getEmail(), activation.getUserCode());

        emailsService.send(
            Map.of(
                "email", profile.getEmail(),
                "name", String.format("%s %s", profile.getFirstName(), profile.getLastName()),
                "code", ""+activation.getUserCode(),
                "template", "activation-code.ftl"
            )
        );



        return thisprofile;
    }

    public void validate(Map<String, String> parameters) {

         Profile profile = this.activationsService.validaAndReturnProfile(parameters);

         profile.setActive(true);

         this.profileRepository.save(profile);

    }
}
