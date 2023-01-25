package com.kn.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidShipmentException.class)
    ProblemDetail handleBadShipmentException(InvalidShipmentException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("Bad shipment data");
        problemDetail.setType(URI.create("https://api.shipments.kn.com/errors/not-found"));
        problemDetail.setProperty("Service", "Core Shipment Service");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}