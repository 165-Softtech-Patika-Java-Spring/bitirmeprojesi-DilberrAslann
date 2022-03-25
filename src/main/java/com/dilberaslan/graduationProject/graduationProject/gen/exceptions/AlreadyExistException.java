package com.dilberaslan.graduationProject.graduationProject.gen.exceptions;

import com.dilberaslan.graduationProject.graduationProject.gen.enums.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author dilbe
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistException extends GenBusinessException {

    public AlreadyExistException(BaseErrorMessage message) {
        super(message);
    }
}
