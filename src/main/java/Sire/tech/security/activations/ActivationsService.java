package Sire.tech.security.activations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Sire.tech.profiles.Profile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ActivationsService {

    private ActivationsRepository activationsRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Activations create(Profile profile) {

        // Générer mon code d'activation

        Random random = new Random();

        int useCode = random.nextInt(900000) + 100000;

        Activations activation = Activations.builder()
            .userCode(useCode)
            .code(bCryptPasswordEncoder.encode(""+useCode))
            .active(Boolean.TRUE)
            .creation(LocalDateTime.now())
            .desactivation(LocalDateTime.now().plusMinutes(5))
            .profile(profile)
            .build();
        return activationsRepository.save(activation);
    }

    public Profile validaAndReturnProfile(Map<String, String> parameters) {

       List<Activations> activations =  this.activationsRepository.findAllByActiveAndDesactivationAfter(
            true,
            LocalDateTime.now()
       );

        activations = activations.stream().filter(activation -> bCryptPasswordEncoder.matches(
            parameters.get("code"),
            activation.getCode()

       ) ).toList();

        if (activations.isEmpty()) {
            throw new RuntimeException("Le code saisi est invalide ou a expiré");
        }

        Activations activation = activations.getFirst();
        activation.setActive(Boolean.FALSE);
        this.activationsRepository.save(activation);

        return activation.getProfile();


    };





}
