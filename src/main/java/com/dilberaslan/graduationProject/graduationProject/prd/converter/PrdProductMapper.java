package com.dilberaslan.graduationProject.graduationProject.prd.converter;

import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductDto;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductSaveRequestDto;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductUpdateRequestDto;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Dilber
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrdProductMapper {
    PrdProductMapper INSTANCE = Mappers.getMapper(PrdProductMapper.class);

    PrdProduct convertToPrdProduct(PrdProductSaveRequestDto prdProductSaveRequestDto);

    PrdProductDto convertToPrdProductDto(PrdProduct prdProduct);

    PrdProduct convertToPrdProduct(PrdProductUpdateRequestDto prdProductUpdateRequestDto);

    List<PrdProductDto> convertToPrdProductDtoList(List<PrdProduct> prdProductList);


}
