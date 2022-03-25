package com.dilberaslan.graduationProject.graduationProject.prd.dto;

import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Dilber
 */
@Data
public class PrdProductTypeDto {

    private Long id;
    private PrdProductTypeName prdProductTypeName;
    private BigDecimal kdv;

}
