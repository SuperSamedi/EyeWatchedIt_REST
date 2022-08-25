package org.petitpont.eyewatchedit.controllers;

import org.petitpont.eyewatchedit.exceptions.ElementNotFoundException;
import org.petitpont.eyewatchedit.models.dtos.ErrorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdviser {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(ElementNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message( ex.getMessage() )
                                .receivedAt( LocalDateTime.now() )
                                .status( HttpStatus.NOT_FOUND.value() )
                                .method( HttpMethod.resolve(request.getMethod()) )
                                .path( request.getRequestURL().toString() )
                                .build()
                );
    }
}
