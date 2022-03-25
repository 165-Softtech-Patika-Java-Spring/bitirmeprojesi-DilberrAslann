package com.dilberaslan.graduationProject.graduationProject.sec.controller;

import com.dilberaslan.graduationProject.graduationProject.gen.dto.RestResponse;
import com.dilberaslan.graduationProject.graduationProject.sec.dto.SecLoginRequestDto;
import com.dilberaslan.graduationProject.graduationProject.sec.service.AuthenticationService;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserDto;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserSaveRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dilber
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(tags = "Authentication Controller")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody SecLoginRequestDto secLoginRequestDto) {

        String token = authenticationService.login(secLoginRequestDto);

        return ResponseEntity.ok(RestResponse.of(token));
    }

    @Operation(tags = "Authentication Controller")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto) {

        UsrUserDto usrUserDto = authenticationService.register(usrUserSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }
}
