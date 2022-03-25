package com.dilberaslan.graduationProject.graduationProject.prd.entity;

import com.dilberaslan.graduationProject.graduationProject.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Dilber
 */
@Entity
@Table(name = "PRD_PRODUCT")
@Data
public class PrdProduct extends BaseEntity {

    @Id
    @SequenceGenerator(name = "PrdProduct", sequenceName = "PRD_PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "PrdProduct")
    private Long id;

    @Column(name = "ID_PRD_PRODUCT_TYPE")
    private Long prdProductTypeId;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PRICE", precision = 19, scale = 2)
    private BigDecimal price;

    @Column(name = "PRICE_WITH_KDV", precision = 19, scale = 2)
    private BigDecimal priceWithKdv;

    @Column(name = "KDV_PRICE", precision = 19, scale = 2)
    private BigDecimal kdvPrice;


}


