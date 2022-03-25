package com.dilberaslan.graduationProject.graduationProject.prd.dto;

import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author dilbe
 */
@Data
public class PrdProductTypeSaveRequestDto {

    private PrdProductTypeName prdProductTypeName;
    private BigDecimal kdv;
}
