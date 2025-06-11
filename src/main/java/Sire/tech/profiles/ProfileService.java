package Sire.tech.profiles;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@AllArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @PostMapping
    public void create(@RequestBody Profile profile){
        profileRepository.save(profile);
    }




}
