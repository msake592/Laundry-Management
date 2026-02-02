package com.dormlaundry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReservationNotAllowedException extends RuntimeException {
    public ReservationNotAllowedException(String message){
        super(message);
    }
}
    
