package com.example.hotellisting.utils.exception;

import com.example.hotellisting.codetype.InfoType;
import com.example.hotellisting.utils.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional(dontRollbackOn = HotelInfoAppException.class, rollbackOn = HotelRuntimeAppException.class)
public class TransactionInfo {

    private Set<String> errorMessages = new HashSet<String>();
    private List<String> warningMessages = new ArrayList<String>();
    private boolean isErrorOccurred = false;

    @Autowired
    private ErrorMessages messagesProperties;

    public Set<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Set<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<String> getWarningMessages() {
        return warningMessages;
    }

    public void setWarningMessages(List<String> warningMessages) {
        this.warningMessages = warningMessages;
    }

    public boolean isErrorOccurred() {
        return isErrorOccurred;
    }

    public void setErrorOccurred(boolean isErrorOccurred) {
        this.isErrorOccurred = isErrorOccurred;
    }

    public void addErrorMessageByKey(String errorMessageKey) {
        errorMessages.add(messagesProperties.getProperty(errorMessageKey));
        setErrorOccurred(true);
    }

    public void clearErrorMessages() {
        errorMessages.clear();
        setErrorOccurred(false);
    }

    public Set<String> fireErrorMessages() {
        Set<String> errorMessages1 = new HashSet<String>();
        errorMessages1.addAll(getErrorMessages());
        clearErrorMessages();
        return errorMessages1;

    }

    public void generateException(String messageKey, InfoType notificationinfo, HttpStatus status) {
        throw new HotelInfoAppException(messagesProperties.getProperty(messageKey), notificationinfo, status);
    }

    public void generateException(String messageKey, List<Object> args, InfoType notificationinfo,
                                  HttpStatus status) {
        throw new HotelInfoAppException(messagesProperties.getProperty(messageKey, args), notificationinfo, status);
    }

    public void generateRuntimeException(String messageKey, InfoType notificationinfo, HttpStatus status) {
        throw new HotelRuntimeAppException(messagesProperties.getProperty(messageKey), notificationinfo, status);
    }

    public void generateRuntimeException(String messageKey, List<Object> args, InfoType notificationinfo,
                                         HttpStatus status) {
        throw new HotelRuntimeAppException(messagesProperties.getProperty(messageKey, args), notificationinfo, status);
    }

}
