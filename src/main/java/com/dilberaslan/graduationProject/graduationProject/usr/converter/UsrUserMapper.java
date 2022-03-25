package com.dilberaslan.graduationProject.graduationProject.usr.converter;

import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserDto;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserSaveRequestDto;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserUpdateRequestDto;
import com.dilberaslan.graduationProject.graduationProject.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author Dilber
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {

    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);

    UsrUser convertToUsrUser(UsrUserSaveRequestDto usrUserSaveRequestDto);

    UsrUserDto convertToUsrUserDto(UsrUser usrUser);

    UsrUser convertToUsrUser(UsrUserUpdateRequestDto usrUserUpdateRequestDto);

}
