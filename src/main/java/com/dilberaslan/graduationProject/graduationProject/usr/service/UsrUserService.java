package com.dilberaslan.graduationProject.graduationProject.usr.service;

import com.dilberaslan.graduationProject.graduationProject.gen.exceptions.AlreadyExistException;
import com.dilberaslan.graduationProject.graduationProject.gen.exceptions.ItemNotFoundException;
import com.dilberaslan.graduationProject.graduationProject.usr.converter.UsrUserMapper;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserDto;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserSaveRequestDto;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserUpdateRequestDto;
import com.dilberaslan.graduationProject.graduationProject.usr.entity.UsrUser;
import com.dilberaslan.graduationProject.graduationProject.usr.enums.UsrErrorMessage;
import com.dilberaslan.graduationProject.graduationProject.usr.service.entityService.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Dilber
 */
@Service
@RequiredArgsConstructor
public class UsrUserService {
    private final UsrUserEntityService usrUserEntityService;
    private final PasswordEncoder passwordEncoder;

    public UsrUserDto save(UsrUserSaveRequestDto usrUserSaveRequestDto) {
        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserSaveRequestDto);

        String password = passwordEncoder.encode(usrUser.getPassword());
        usrUser.setPassword(password);

        usrUser = usrUserEntityService.saveWithControl(usrUser);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }

    public void delete(Long id) {
        UsrUser usrUser = usrUserEntityService.getByIdWithControl(id);

        usrUserEntityService.delete(usrUser);
    }

    public UsrUserDto update(UsrUserUpdateRequestDto usrUserUpdateRequestDto) {


        controlIsUserExist(usrUserUpdateRequestDto);

        UsrUser usrUser;
        usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserUpdateRequestDto);
        usrUser = usrUserEntityService.save(usrUser);

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }

    private void controlIsUserExist(UsrUserUpdateRequestDto usrUserUpdateRequestDto) {
        Long id = usrUserUpdateRequestDto.getId();
        boolean isExist = usrUserEntityService.existsById(id);
        if (!isExist) {
            throw new ItemNotFoundException(UsrErrorMessage.USER_ERROR_MESSAGE);
        }

        String username = usrUserUpdateRequestDto.getUserName();
        Optional<UsrUser> usrUser = usrUserEntityService.findByUserName(username);

        if (usrUser.isPresent() && usrUser.get().getId() != id) {
            throw new AlreadyExistException(UsrErrorMessage.USER_ALREADY_IS_EXIST);
        }

    }
}
