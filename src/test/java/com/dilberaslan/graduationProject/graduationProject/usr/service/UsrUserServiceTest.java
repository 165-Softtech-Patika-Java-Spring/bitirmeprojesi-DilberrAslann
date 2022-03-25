package com.dilberaslan.graduationProject.graduationProject.usr.service;

import com.dilberaslan.graduationProject.graduationProject.usr.service.entityService.UsrUserEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dilbe
 */
@ExtendWith(MockitoExtension.class)
class UsrUserServiceTest {

    @InjectMocks
    private UsrUserService userService;

    @Mock
    private UsrUserEntityService usrUserEntityService;
    @Mock
    private PasswordEncoder passwordEncoder;



    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}