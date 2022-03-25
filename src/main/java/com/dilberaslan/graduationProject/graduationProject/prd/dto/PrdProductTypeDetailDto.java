package com.dilberaslan.graduationProject.graduationProject.prd.dto;

import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author dilbe
 */
@AllArgsConstructor
@Data
public class PrdProductTypeDetailDto {

    private PrdProductTypeName prdProductTypeName;
    private BigDecimal kdv;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Double averagePrice;
    private Long count;
}
