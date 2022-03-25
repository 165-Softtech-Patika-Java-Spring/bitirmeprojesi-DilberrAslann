package com.dilberaslan.graduationProject.graduationProject.usr.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Dilber
 */
@Data
public class UsrUserSaveRequestDto {

    @NotNull(message = "name can not be null")
    @NotEmpty(message = "name can not be empty")
    @NotBlank
    private String name;

    private String surname;

    @NotNull(message = "username can not be null")
    @NotEmpty(message = "name can not be empty")
    @NotBlank
    private String userName;

    private String password;
}
