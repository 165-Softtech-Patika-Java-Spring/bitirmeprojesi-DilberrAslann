package com.dilberaslan.graduationProject.graduationProject.prd.converter;

import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductTypeDto;
import com.dilberaslan.graduationProject.graduationProject.prd.dto.PrdProductTypeSaveRequestDto;
import com.dilberaslan.graduationProject.graduationProject.prd.entity.PrdProductType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author Dilber
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrdProductTypeMapper {

    PrdProductTypeMapper INSTANCE = Mappers.getMapper(PrdProductTypeMapper.class);

    PrdProductTypeDto convertToPtyProductTypeDto(PrdProductType prdProductType);


}
