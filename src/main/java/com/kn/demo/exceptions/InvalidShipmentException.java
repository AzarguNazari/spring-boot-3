package com.kn.demo.exceptions;

public class InvalidShipmentException extends RuntimeException {

    public InvalidShipmentException() {
        super("Invalid shipment details");
    }
}
