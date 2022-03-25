package com.dilberaslan.graduationProject.graduationProject.prd.service.entityService;

import com.dilberaslan.graduationProject.graduationProject.gen.service.BaseEntityService;
import com.dilberaslan.graduationProject.graduationProject.prd.dao.PrdProductDao;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProduct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Dilber
 */
@Service
public class PrdProductEntityService extends BaseEntityService<PrdProduct, PrdProductDao> {

    public PrdProductEntityService(PrdProductDao dao) {
        super(dao);
    }


    public List<PrdProduct> findAllByPriceWithKdvBetween(BigDecimal firstPrice, BigDecimal finalPrice) {
        return getDao().findAllByPriceWithKdvBetween(firstPrice, finalPrice);
    }


    public List<PrdProduct> findAllByProductTypeId(Long id) {
        return getDao().findAllByPrdProductTypeId(id);
    }


    public List<PrdProduct> saveAll(List<PrdProduct> prdProductList) {
        return getDao().saveAll(prdProductList);
    }
}
