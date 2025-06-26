package Sire.tech.Authentification;

import Sire.tech.profiles.Profile;
import Sire.tech.profiles.ProfileDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AuthentificationController {

    private final AuthentificationService authentificationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "sign-up")
    public Profile create(@RequestBody ProfileDTO profileDTO){
            return this.authentificationService.create(profileDTO);
    }
}
