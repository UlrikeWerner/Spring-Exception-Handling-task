package de.neuefische.springexceptionhandlingtask;

import java.time.LocalDateTime;

public record ErrorMessage(
        String errorMessage,
        LocalDateTime timestamp
) {
}
