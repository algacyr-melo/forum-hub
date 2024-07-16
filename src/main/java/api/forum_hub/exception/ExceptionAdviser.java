package api.forum_hub.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionAdviser {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle404() {

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldError>> handle400(MethodArgumentNotValidException e) {

        var errors = e.getFieldErrors();
        return ResponseEntity.badRequest().body(errors);
    }
}
