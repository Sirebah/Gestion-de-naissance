package Sire.tech.profiles;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@AllArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public void create(Profile profile) {
        profileRepository.save(profile);
    }


    public List<Profile> findProfiles(){
        return profileRepository.findAll();
    }

    public Profile findProfileById(int id){
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.orElse(null);
    }

    public Profile updateProfile(int id,Profile profile){
        Profile profileToUpdate = findProfileById(id);

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
