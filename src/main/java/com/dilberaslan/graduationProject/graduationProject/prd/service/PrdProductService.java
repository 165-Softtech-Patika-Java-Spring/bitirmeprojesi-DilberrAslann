package com.dilberaslan.graduationProject.graduationProject.prd.service;

import com.dilberaslan.graduationProject.graduationProject.gen.exceptions.ItemNotFoundException;
import com.dilberaslan.graduationProject.graduationProject.prd.converter.PrdProductMapper;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductDto;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductSaveRequestDto;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductUpdateRequestDto;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProduct;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProductType;
import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdErrorMessage;
import com.dilberaslan.graduationProject.graduationProject.prd.enums.PrdProductTypeName;
import com.dilberaslan.graduationProject.graduationProject.prd.service.entityService.PrdProductEntityService;
import com.dilberaslan.graduationProject.graduationProject.prd.service.entityService.PrdProductTypeEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Dilber
 */
@Service
@RequiredArgsConstructor
public class PrdProductService {
    private final PrdProductEntityService prdProductEntityService;
    private final PrdProductTypeEntityService prdProductTypeEntityService;


    public PrdProductDto save(PrdProductSaveRequestDto prdProductSaveRequestDto) {

        PrdProduct prdProduct = PrdProductMapper.INSTANCE.convertToPrdProduct(prdProductSaveRequestDto);

        PrdProductTypeName prdProductTypeName = prdProductSaveRequestDto.getPrdProductTypeName();
        PrdProductType prdProductType = prdProductTypeEntityService.findByPrdProductTypeName(prdProductTypeName);

        Long productTypeId = prdProductType.getId();

        prdProduct.setPrdProductTypeId(productTypeId);

        BigDecimal price = prdProductSaveRequestDto.getPrice();

        calculatePrices(price, prdProduct, prdProductType);

        prdProduct = prdProductEntityService.save(prdProduct);

        PrdProductDto prdProductDto = PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);

        return prdProductDto;

    }

    private void calculatePrices(BigDecimal price, PrdProduct prdProduct, PrdProductType prdProductType) {
        BigDecimal kdv = prdProductType.getKdv();

        BigDecimal priceWithKdv = price.add(price.multiply(kdv).divide(new BigDecimal(100)));

        BigDecimal kdvPrice = priceWithKdv.subtract(price);

        prdProduct.setPriceWithKdv(priceWithKdv);
        prdProduct.setKdvPrice(kdvPrice);

    }

    public void calculatePricesWithUpdatedProductType(PrdProduct prdProduct, BigDecimal updatedKDV) {
        BigDecimal price = prdProduct.getPrice();

        BigDecimal priceWithKdv = price.add(price.multiply(updatedKDV).divide(new BigDecimal(100)));

        BigDecimal kdvPrice = priceWithKdv.subtract(price);

        prdProduct.setPriceWithKdv(priceWithKdv);
        prdProduct.setKdvPrice(kdvPrice);

    }


    public void delete(Long id) {
        PrdProduct prdProduct = prdProductEntityService.getByIdWithControl(id);

        prdProductEntityService.delete(prdProduct);
    }

    public PrdProductDto update(PrdProductUpdateRequestDto prdProductUpdateRequestDto) {
        controlIsProductExist(prdProductUpdateRequestDto);

        PrdProduct prdProduct;
        prdProduct = PrdProductMapper.INSTANCE.convertToPrdProduct(prdProductUpdateRequestDto);

        Long productTypeId = prdProductUpdateRequestDto.getPrdProductTypeId();

        Optional<PrdProductType> optionalPrdProductType = prdProductTypeEntityService.findById(productTypeId);

        if (!optionalPrdProductType.isPresent()) {
            throw new ItemNotFoundException(PrdErrorMessage.PRODUCT_TYPE_ERROR_MESSAGE);
        }
        BigDecimal price = prdProductUpdateRequestDto.getPrice();

        PrdProductType prdProductType = optionalPrdProductType.get();

        calculatePrices(price, prdProduct, prdProductType);
        prdProduct = prdProductEntityService.save(prdProduct);

        PrdProductDto prdProductDto = PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);

        return prdProductDto;
    }

    private void controlIsProductExist(PrdProductUpdateRequestDto prdProductUpdateRequestDto) {
        Long id = prdProductUpdateRequestDto.getId();
        boolean isExist = prdProductEntityService.existsById(id);
        if (!isExist) {
            throw new ItemNotFoundException(PrdErrorMessage.PRODUCT_ERROR_MESSAGE);/////
        }
    }

    public List<PrdProductDto> findAll() {

        List<PrdProduct> prdProductList = prdProductEntityService.findAll();

        List<PrdProductDto> prdProductDtoList = PrdProductMapper.INSTANCE.convertToPrdProductDtoList(prdProductList);

        return prdProductDtoList;
    }

    public PrdProductDto updatePrice(Long id, BigDecimal price) {


        Optional<PrdProduct> optionalPrdProduct = prdProductEntityService.findById(id);

        if (!optionalPrdProduct.isPresent()) {
            throw new ItemNotFoundException(PrdErrorMessage.PRODUCT_ERROR_MESSAGE);
        }
        Long prdProductTypeId = optionalPrdProduct.get().getPrdProductTypeId();

        Optional<PrdProductType> optionalPrdProductType = prdProductTypeEntityService.findById(prdProductTypeId);

        if (!optionalPrdProductType.isPresent()) {
            throw new ItemNotFoundException(PrdErrorMessage.PRODUCT_TYPE_ERROR_MESSAGE);

        }
        PrdProduct prdProduct = optionalPrdProduct.get();

        PrdProductType prdProductType = optionalPrdProductType.get();

        calculatePrices(price, prdProduct, prdProductType);

        prdProduct.setPrice(price);

        prdProduct = prdProductEntityService.save(prdProduct);

        PrdProductDto prdProductDto = PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);

        return prdProductDto;

    }


    public List<PrdProductDto> findAllByPriceWithKdvBetween(BigDecimal firstPrice, BigDecimal finalPrice) {


        List<PrdProduct> prdProductList = prdProductEntityService.findAllByPriceWithKdvBetween(firstPrice, finalPrice);

        List<PrdProductDto> prdProductDtoList = PrdProductMapper.INSTANCE.convertToPrdProductDtoList(prdProductList);

        return prdProductDtoList;
    }


    public List<PrdProductDto> findAllByProductType(PrdProductTypeName prdProductTypeName) {

        PrdProductType productTypeName = prdProductTypeEntityService.findByPrdProductTypeName(prdProductTypeName);

        Long productTypeNameId = productTypeName.getId();

        List<PrdProduct> prdProductList = prdProductEntityService.findAllByProductTypeId(productTypeNameId);

        List<PrdProductDto> prdProductDtoList = PrdProductMapper.INSTANCE.convertToPrdProductDtoList(prdProductList);

        return prdProductDtoList;

    }


}
