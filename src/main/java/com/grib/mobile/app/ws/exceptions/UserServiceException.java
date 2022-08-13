package com.grib.mobile.app.ws.exceptions;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = 4278065886208322401L;

    public UserServiceException(String message) {
        super(message);
    }
}
