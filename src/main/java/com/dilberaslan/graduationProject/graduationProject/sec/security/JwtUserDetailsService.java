package com.dilberaslan.graduationProject.graduationProject.sec.security;

import com.dilberaslan.graduationProject.graduationProject.gen.exceptions.ItemNotFoundException;
import com.dilberaslan.graduationProject.graduationProject.usr.entity.UsrUser;
import com.dilberaslan.graduationProject.graduationProject.usr.enums.UsrErrorMessage;
import com.dilberaslan.graduationProject.graduationProject.usr.service.entityService.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @author Dilber
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UsrUserEntityService usrUserEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UsrUser> usrUser = usrUserEntityService.findByUserName(username);

        if (!usrUser.isPresent()) {
            throw new ItemNotFoundException(UsrErrorMessage.USER_ERROR_MESSAGE);
        }

        return JwtUserDetails.create(usrUser.get());
    }

//    public UserDetails customizedLoadUserByUsername(String username) {
//
//        UsrUser usrUser = usrUserEntityService.findByUsernameWithControl(username);
//
//        return JwtUserDetails.create(usrUser);
//    }
}
