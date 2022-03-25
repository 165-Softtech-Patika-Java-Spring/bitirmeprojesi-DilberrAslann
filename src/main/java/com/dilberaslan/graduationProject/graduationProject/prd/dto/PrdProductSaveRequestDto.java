package com.dilberaslan.graduationProject.graduationProject.prd.dto;

import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

/**
 * @author Dilber
 */
@Data
public class PrdProductSaveRequestDto {

    private PrdProductTypeName prdProductTypeName;

    @NotNull(message = "Name can not be null")
    @NotEmpty(message = "Name can not be empty")
    @NotBlank(message = "Name can not be blank")
    private String name;

    @Positive
    @NotNull(message = "Price can not be null")
    private BigDecimal price;


}
