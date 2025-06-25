package Sire.tech.shared.exceptions;

import java.time.LocalDateTime;

public record ErrorEntity(
    LocalDateTime timestamp,
    int status,
    String code,
    String message
) {


}

