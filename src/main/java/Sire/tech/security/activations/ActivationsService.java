package Sire.tech.security.activations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import Sire.tech.profiles.Profile;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ActivationsService {

    private ActivationsRepository activationsRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Activations create(Profile profile) {

        // Générer mon code d'activation

        Random random = new Random();

        int useCode = random.nextInt(900000) + 100000;

        Activations activations = Activations.builder()
            .userCode(useCode)
            .code(bCryptPasswordEncoder.encode(""+useCode))
            .active(Boolean.TRUE)
            .creation(LocalDateTime.now())
            .desactivation(LocalDateTime.now().plusMinutes(5))
            .profile(profile)
            .build();
        return activationsRepository.save(activations);
    }


}
