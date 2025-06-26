package Sire.tech.profiles;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("profiles")
public class ProfileController {

    private final ProfileService profileService;




    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<ProfileDTO> findAllProfiles(){
        return this.profileService.findProfiles();
    }

    @GetMapping("{id}")
    public Profile findOneProfile(@PathVariable int id){
        return this.profileService.findProfileById(id);
    }
    @PutMapping("{id}")

    public Profile update(@PathVariable int id, @RequestBody Profile profile){

        return this.profileService.updateProfile(id, profile);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.profileService.deleteProfile(id);
    }


    }


