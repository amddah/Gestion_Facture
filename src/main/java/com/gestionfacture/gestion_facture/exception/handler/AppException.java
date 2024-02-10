package com.gestionfacture.gestion_facture.exception.handler;

import com.gestionfacture.gestion_facture.Shared.ErrorMessage;
import com.gestionfacture.gestion_facture.exception.EntityAlreadyExistsException;
import com.gestionfacture.gestion_facture.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppException {
    @ExceptionHandler
    public ResponseEntity<Object> entityNotFoundExeception(EntityNotFoundException ex){
        ErrorMessage errorMessage =ErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(new Date())
                .code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException ex){
        ErrorMessage errorMessage =ErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(new Date())
                .code(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerMothodeArgumantNoValide(MethodArgumentNotValidException ex){

        Map<String,String> errors =new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
        return new ResponseEntity<>(errors,new HttpHeaders(),HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
