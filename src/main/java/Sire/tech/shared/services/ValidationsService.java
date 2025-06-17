package Sire.tech.shared.services;

import org.springframework.stereotype.Component;

@Component
public class ValidationsService {

    public void validateEmail(String email){
        if(email == null){
            throw new RuntimeException("le mail est réquis");
        }
        if(!email.contains("@") || !email.contains(".") || email.indexOf("@") == email.length()-1 || email.indexOf(".") == email.length()-1 || email.indexOf("@") == 0 ){
            throw new RuntimeException("le mail est invalide");

        }

    }
    public void validatePassword(String password){
        if (password == null){
            throw new RuntimeException("Le mot de est réquis");
        }
        if (password.length() < 4){
            throw new RuntimeException("Le mot de passe doit avoir au moins 4 caracteres");
        }

    }

    public void validatePhone(String phone){
        if (phone == null){
            throw new RuntimeException("Le telephone est réquis");
        }
        if (phone.length() < 9){
            throw new RuntimeException("Le téléphone est invalide");

        }
    }
}
