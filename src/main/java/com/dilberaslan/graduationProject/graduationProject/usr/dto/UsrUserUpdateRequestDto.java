package com.dilberaslan.graduationProject.graduationProject.usr.dto;

import lombok.Data;

/**
 * @author Dilber
 */
@Data
public class UsrUserUpdateRequestDto {

    private Long id;
    private String name;
    private String surname;
    private String userName;
    private String password;
}
