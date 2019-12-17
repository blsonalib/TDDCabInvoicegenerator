package com.cabinvoicegenerator;

public class CabServiceException extends Exception {

    enum ExceptionType {
        NULL_ID, RIDE_NOT_FOUND
    }

    ExceptionType type;

    public CabServiceException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

    public CabServiceException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CabServiceException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
