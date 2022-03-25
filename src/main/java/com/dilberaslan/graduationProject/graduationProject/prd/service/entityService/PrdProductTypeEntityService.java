package com.dilberaslan.graduationProject.graduationProject.prd.service.entityService;

import com.dilberaslan.graduationProject.graduationProject.gen.exceptions.ItemNotFoundException;
import com.dilberaslan.graduationProject.graduationProject.gen.service.BaseEntityService;
import com.dilberaslan.graduationProject.graduationProject.prd.dao.PrdProductTypeDao;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductTypeDetailDto;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProductType;
import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdErrorMessage;
import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Dilber
 */
@Service
public class PrdProductTypeEntityService extends BaseEntityService<PrdProductType, PrdProductTypeDao> {
    public PrdProductTypeEntityService(PrdProductTypeDao dao) {
        super(dao);
    }


    public PrdProductType findByPrdProductTypeName(PrdProductTypeName prdProductTypeName) {
        return getDao().findByPrdProductTypeName(prdProductTypeName).orElseThrow(() -> new ItemNotFoundException(PrdErrorMessage.PRODUCT_TYPE_ERROR_MESSAGE));
    }


    public List<PrdProductTypeDetailDto> findAllProductWithDetail() {

        List<PrdProductTypeDetailDto> allProductWithDetail = getDao().findAllProductWithDetail();

        for (PrdProductTypeDetailDto prdProductTypeDetailDto : allProductWithDetail) {
            if (prdProductTypeDetailDto.getCount() == 0) {
                prdProductTypeDetailDto.setAveragePrice(0d);
                prdProductTypeDetailDto.setMaxPrice(BigDecimal.ZERO);
                prdProductTypeDetailDto.setMinPrice(BigDecimal.ZERO);
            }

        }

        return allProductWithDetail;
    }


}

