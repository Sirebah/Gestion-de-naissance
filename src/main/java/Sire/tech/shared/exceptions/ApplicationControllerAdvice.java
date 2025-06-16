package Sire.tech.shared.exceptions;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.LocalDateTime;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// il faut toujour utiliser @RestControllerAdvice pour les API rest pour qu'il puisse retourner directement du json au de ControllerAdvice où tu seras obligé de mettre @ResponseBody sur la methode
@Slf4j
@ControllerAdvice
public class ApplicationControllerAdvice {

   @ResponseStatus(NOT_FOUND)
   @ResponseBody
   @ExceptionHandler(EntityNotFoundException.class)
    public ErrorEntity handleEntityNotFoundException(EntityNotFoundException ex){
       ex.printStackTrace();
       log.error("erreur: {}", ex.getMessage()); // un log pour afficher l'erreur avec le message dans la console
       return new ErrorEntity(LocalDateTime.now(),
           NOT_FOUND.value(),
            null,
           ex.getMessage());
   }

   @ResponseStatus(HttpStatus.BAD_REQUEST)
   @ResponseBody
   @ExceptionHandler(IllegalArgumentException.class)
    public ErrorEntity handleIllegalArgumentException(IllegalArgumentException ex){
       ex.printStackTrace();
       log.error("erreur: {}", ex.getMessage());
       return new ErrorEntity(LocalDateTime.now(),
           NOT_FOUND.value(),
           null,
           "l'argument est invalide veuillez vérifier l'id il doit-être un entier");
   }
}
