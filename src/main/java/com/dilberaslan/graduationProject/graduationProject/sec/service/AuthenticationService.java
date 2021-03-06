package com.dilberaslan.graduationProject.graduationProject.sec.service;

import com.dilberaslan.graduationProject.graduationProject.sec.dto.SecLoginRequestDto;
import com.dilberaslan.graduationProject.graduationProject.sec.enums.EnumJwtConstant;
import com.dilberaslan.graduationProject.graduationProject.sec.security.JwtTokenGenerator;
import com.dilberaslan.graduationProject.graduationProject.sec.security.JwtUserDetails;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserDto;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserSaveRequestDto;
import com.dilberaslan.graduationProject.graduationProject.usr.entity.UsrUser;
import com.dilberaslan.graduationProject.graduationProject.usr.service.UsrUserService;
import com.dilberaslan.graduationProject.graduationProject.usr.service.entityService.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Dilber
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsrUserService usrUserService;
    private final UsrUserEntityService usrUserEntityService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    public UsrUserDto register(UsrUserSaveRequestDto usrUserSaveRequestDto) {

        UsrUserDto usrUserDto = usrUserService.save(usrUserSaveRequestDto);

        return usrUserDto;
    }

    public String login(SecLoginRequestDto secLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(secLoginRequestDto.getUserName(), secLoginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String bearer = EnumJwtConstant.BEARER.getConstant();

        return bearer + token;
    }

    public UsrUser getCurrentUser() {

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        UsrUser usrUser = null;
        if (jwtUserDetails != null) {
            usrUser = usrUserEntityService.getByIdWithControl(jwtUserDetails.getId());
        }

        return usrUser;
    }

    public Long getCurrentUserId() {

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        Long jwtUserDetailsId = null;
        if (jwtUserDetails != null) {
            jwtUserDetailsId = jwtUserDetails.getId();
        }

        return jwtUserDetailsId;
    }

    private JwtUserDetails getCurrentJwtUserDetails() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JwtUserDetails jwtUserDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof JwtUserDetails) {
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        }
        return jwtUserDetails;
    }
}
