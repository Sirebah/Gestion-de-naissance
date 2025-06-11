package Sire.tech.profiles;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Profile {
    @Id()
    int id ;
    String FirstName;
    String LastName;
    String Email;
    String Password;
}
