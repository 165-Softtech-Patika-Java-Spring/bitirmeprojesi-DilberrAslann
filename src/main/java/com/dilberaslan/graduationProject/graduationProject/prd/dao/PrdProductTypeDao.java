package com.dilberaslan.graduationProject.graduationProject.prd.dao;

import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductTypeDetailDto;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProductType;
import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Dilber
 */
@Repository
public interface PrdProductTypeDao extends JpaRepository<PrdProductType, Long> {


    Optional<PrdProductType> findByPrdProductTypeName(PrdProductTypeName prdProductTypeName);

    @Query(value = "SELECT " +
            "new com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductTypeDetailDto(" +
            "prdProductType.prdProductTypeName," +
            "prdProductType.kdv, " +
            "min(prdProduct.priceWithKdv), " +
            "max(prdProduct.priceWithKdv), " +
            "avg(prdProduct.priceWithKdv), " +
            "count(prdProduct)) " +
            "FROM PrdProductType prdProductType " +
            "LEFT JOIN PrdProduct prdProduct " +
            "ON prdProductType.id = prdProduct.prdProductTypeId " +
            "GROUP BY prdProductType.id")
    List<PrdProductTypeDetailDto> findAllProductWithDetail();

}
