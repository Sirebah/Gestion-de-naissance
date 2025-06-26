package Sire.tech.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// l'objectif de cette classe, c'est pas d'être utiliser comme les autres class
// mais c'est comme une usine de fabrication qui nous permet de produire des Bean à travers méthode ic,
// c'est-à-dire des objets utilisables à tous les niveaux de l'application
// il crée une seule instance des object retourné dans les méthode déclarer ici avec l'annotation @Bean
// et ils leur stockent dans un container appélé (spring Application context)
// donc quand on veut les utilser on fait seulement l'injection de dépendances et puis il utilise le même objet
// ça évite de créer des object partout avec les new Maclass();

// et aussi il faut savoir que les classe @service , @Repository @controller , @Contenant , on leur Bean directement
// c'est à dire un seul objet de leurs instance stocker dans le container spring

// donc ici si tu as une classe qui n'est ni un service ni un component ... , tu peux faire ici dans la classe @Configuration
// l'ancapsuler dans une méthode Anoté @Bean  fais un (return new la class ) avec type de retour la class
//
@Configuration
public class ApplicationPasswordEncoder {

    // retourne une seule instance de la classe BcrypPassword qui peut être utiliser partout dans l'application
    // la classe BCryptPasswordEncoder existe d'éjà c'est pour créer une seule instance utilisable partout on est là
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
