package com.dilberaslan.graduationProject.graduationProject.usr.enums;

import com.dilberaslan.graduationProject.graduationProject.gen.enums.BaseErrorMessage;


/**
 * @author Dilber
 */
public enum UsrErrorMessage implements BaseErrorMessage {

    USER_ERROR_MESSAGE("User not found!"),

    USER_ALREADY_IS_EXIST("User already is exist!");;

    private String message;

    UsrErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
