package Sire.tech.shared.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ValidationsServiceTest {

@InjectMocks
ValidationsService validationsService;

    @Test
    void validateEmail() {

        // Arrange (c'est déclarer les variables du test)
        String email = "bahsire1@gmail.com";

        // act
        this.validationsService.validateEmail(email);
        // après assert
    }

    @Test
    void validatePassword() {
        String password = "1115";
        this.validationsService.validatePassword(password);
    }

    @Test
    void validatePhone() {
        String phone = "625627615";
        this.validationsService.validatePhone(phone);
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {

        // arrange
        String mail = null;
        // act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> this.validationsService.validateEmail(mail));
        // assert

        assertEquals("le mail est réquis", exception.getMessage());

    }
}