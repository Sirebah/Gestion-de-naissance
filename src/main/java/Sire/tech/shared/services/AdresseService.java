package Sire.tech.shared.services;

import Sire.tech.shared.entities.Adresse;
import Sire.tech.shared.repositories.AdressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdresseService {

    private final AdressRepository adressRepository;


    public Adresse createAdresse(Adresse adresse){
       return this.adressRepository.save(adresse);

    }

}
