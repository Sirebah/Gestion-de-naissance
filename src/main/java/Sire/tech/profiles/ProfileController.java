package Sire.tech.profiles;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("profiles")
public class ProfileController {

    private final ProfileService profileService;


    @PostMapping
    public void create(@RequestBody Profile profile){
        this.profileService.create(profile);
    }





    }


