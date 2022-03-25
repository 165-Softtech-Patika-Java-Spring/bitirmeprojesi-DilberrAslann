package com.dilberaslan.graduationProject.graduationProject.prd.entity;

import com.dilberaslan.graduationProject.graduationProject.gen.entity.BaseEntity;
import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

/**
 * @author Dilber
 */
@Entity
@Table(name = "PRD_PRODUCT_TYPE")
@Getter
@Setter
public class PrdProductType extends BaseEntity {
    @Id
    @SequenceGenerator(name = "PrdProductType", sequenceName = "PRD_PRODUCT_TYPE_ID_SEQ")
    @GeneratedValue(generator = "PrdProductType")
    private Long id;

    @Column(name = "NAME", length = 30)
    @Enumerated(EnumType.STRING)
    private PrdProductTypeName prdProductTypeName;

    @Column(name = "KDV", nullable = false, precision = 19, scale = 2)
    @PositiveOrZero
    private BigDecimal kdv;

}
