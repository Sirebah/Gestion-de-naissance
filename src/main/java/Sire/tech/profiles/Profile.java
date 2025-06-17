package Sire.tech.profiles;

import java.awt.PageAttributes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String FirstName;
    private String LastName;

    @Enumerated(EnumType.STRING)
    private Civility civility;

    @Column(length = 100, unique = true)
    private String Email;

    private String phone;

    @Column(length = 150)
    private String Password;

}
