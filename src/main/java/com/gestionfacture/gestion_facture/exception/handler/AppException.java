package com.gestionfacture.gestion_facture.exception.handler;

import com.gestionfacture.gestion_facture.Shared.ErrorMessage;
import com.gestionfacture.gestion_facture.exception.EntityAlreadyExistsException;
import com.gestionfacture.gestion_facture.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

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
}
