package cl.ejercicio.exception;

import cl.ejercicio.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class ErrorHandler {


    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity<?> handleEmailException(ValidacionException ce) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDTO(ce.getMensaje()));
    }

    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<?> handleUsuarioException(UsuarioException ce) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDTO(ce.getMensaje()));
    }
}
