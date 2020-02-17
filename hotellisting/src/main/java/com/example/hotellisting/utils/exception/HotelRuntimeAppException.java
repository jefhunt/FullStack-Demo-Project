package com.example.hotellisting.utils.exception;

import com.example.hotellisting.codetype.InfoType;
import com.example.hotellisting.model.response.ErrorMessage;
import org.springframework.http.HttpStatus;

public class HotelRuntimeAppException extends RuntimeException{

    private ErrorMessage errorMessage;

    public HotelRuntimeAppException(String message, InfoType notificationinfo, HttpStatus status) {
        super(message);
        this.errorMessage = new ErrorMessage(message, notificationinfo, status);
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

}
