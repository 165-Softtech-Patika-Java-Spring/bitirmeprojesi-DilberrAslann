package com.dilberaslan.graduationProject.graduationProject.prd.dao;

import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Dilber
 */
@Repository
public interface PrdProductDao extends JpaRepository<PrdProduct, Long> {

    List<PrdProduct> findAllByPriceWithKdvBetween(BigDecimal firstPrice, BigDecimal finalPrice);

    List<PrdProduct> findAllByPrdProductTypeId(Long id);
}
