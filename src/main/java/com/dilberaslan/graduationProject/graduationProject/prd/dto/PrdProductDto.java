package com.dilberaslan.graduationProject.graduationProject.prd.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Dilber
 */
@Data
public class PrdProductDto {
    private Long id;
    private Long prdProductTypeId;
    private String name;
    private BigDecimal price;
    private BigDecimal priceWithKdv;
}
