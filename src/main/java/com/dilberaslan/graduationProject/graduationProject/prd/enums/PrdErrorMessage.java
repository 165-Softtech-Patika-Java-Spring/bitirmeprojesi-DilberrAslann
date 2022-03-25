package com.dilberaslan.graduationProject.graduationProject.prd.enums;

import com.dilberaslan.graduationProject.graduationProject.gen.enums.BaseErrorMessage;


/**
 * @author Dilber
 */
public enum PrdErrorMessage implements BaseErrorMessage {

    PRODUCT_ERROR_MESSAGE("Product not found!"),

    PRODUCT_TYPE_ERROR_MESSAGE("Product Type not found!"),
    ;

    private String message;

    PrdErrorMessage(String message) {
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
