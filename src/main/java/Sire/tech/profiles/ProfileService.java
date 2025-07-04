package Sire.tech.profiles;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import Sire.tech.shared.entities.Adresse;
import Sire.tech.shared.services.AdresseService;
import Sire.tech.shared.services.ValidationsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ValidationsService validationsService;
    private final AdresseService adresseService;
    private final ProfileMapper profileMapper;

    public Profile create(Profile profile) {
        this.validationsService.validateEmail(profile.getEmail());
        this.validationsService.validatePassword(profile.getPassword());
        this.validationsService.validatePhone(profile.getPhone());

        if(profile.getAdresse() != null) {
            Adresse adresse1 = this.adresseService.createAdresse(profile.getAdresse());
            profile.setAdresse(adresse1);
        }

        return profileRepository.save(profile);
    }


    public Set<ProfileDTO> findProfiles(){
        List<Profile> profiles = profileRepository.findAll();

        return profiles.stream().map(this.profileMapper::entityToDto).collect(Collectors.toSet());

    }

    public Profile findProfileById(int id){
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.orElseThrow(() -> new EntityNotFoundException("le profile n'existe pas avec l'id: "+ id) );
    }

    public Profile updateProfile(int id,Profile profile){


        Profile profileToUpdate = findProfileById(id);
        this.validationsService.validateEmail(profile.getEmail());
        this.validationsService.validatePassword(profile.getPassword());
        this.validationsService.validatePhone(profile.getPhone());

        profileToUpdate.setFirstName(profile.getFirstName());
        profileToUpdate.setLastName(profile.getLastName());
        profileToUpdate.setEmail(profile.getEmail());
        profileToUpdate.setPassword(profile.getPassword());
        profileRepository.save(profileToUpdate);
        return profileToUpdate;

    }

    public void deleteProfile(int id){
        profileRepository.deleteById(id);
    }


}
