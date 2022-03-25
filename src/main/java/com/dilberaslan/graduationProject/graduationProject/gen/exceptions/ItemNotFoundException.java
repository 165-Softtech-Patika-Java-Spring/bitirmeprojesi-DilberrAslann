package com.dilberaslan.graduationProject.graduationProject.gen.exceptions;

import com.dilberaslan.graduationProject.graduationProject.gen.enums.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Dilber
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends GenBusinessException {

    public ItemNotFoundException(BaseErrorMessage message) {
        super(message);
    }
}
