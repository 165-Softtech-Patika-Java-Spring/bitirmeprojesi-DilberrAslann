package com.dilberaslan.graduationProject.graduationProject.prd.service;

import com.dilberaslan.graduationProject.graduationProject.gen.exceptions.ItemNotFoundException;
import com.dilberaslan.graduationProject.graduationProject.prd.converter.PrdProductTypeMapper;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductTypeDetailDto;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductTypeDto;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProduct;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProductType;
import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdErrorMessage;
import com.dilberaslan.graduationProject.graduationProject.prd.service.entityService.PrdProductEntityService;
import com.dilberaslan.graduationProject.graduationProject.prd.service.entityService.PrdProductTypeEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Dilber
 */
@Service
@RequiredArgsConstructor
public class PrdProductTypeService {

    private final PrdProductTypeEntityService prdProductTypeEntityService;
    private final PrdProductEntityService productEntityService;
    private final PrdProductService productService;

    @Transactional
    public PrdProductTypeDto updateKDV(Long id, BigDecimal kdv) {

        Optional<PrdProductType> optionalPrdProductType = prdProductTypeEntityService.findById(id);

        if (!optionalPrdProductType.isPresent()) {
            throw new ItemNotFoundException(PrdErrorMessage.PRODUCT_TYPE_ERROR_MESSAGE);
        }

        PrdProductType prdProductType = optionalPrdProductType.get();
        prdProductType.setKdv(kdv);
        prdProductTypeEntityService.save(prdProductType);

        List<PrdProduct> prdProductList = productEntityService.findAllByProductTypeId(id);

        for (PrdProduct prdProduct : prdProductList) {
            productService.calculatePricesWithUpdatedProductType(prdProduct, kdv);
        }
        productEntityService.saveAll(prdProductList);

        PrdProductTypeDto prdProductTypeDto = PrdProductTypeMapper.INSTANCE.convertToPtyProductTypeDto(prdProductType);

        return prdProductTypeDto;

    }

    public List<PrdProductTypeDetailDto> findAllProductWithDetail() {
        return prdProductTypeEntityService.findAllProductWithDetail();
    }


}
