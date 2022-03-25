package com.dilberaslan.graduationProject.graduationProject.usr.controller;

import com.dilberaslan.graduationProject.graduationProject.gen.dto.RestResponse;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserDto;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserSaveRequestDto;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserUpdateRequestDto;
import com.dilberaslan.graduationProject.graduationProject.usr.service.UsrUserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Dilber
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsrUserController {
    private final UsrUserService usrUserService;

//    @Operation(tags = "User Controller")
//    @PostMapping
//    public ResponseEntity save(@Valid @RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto) {
//
//        UsrUserDto usrUserDto = usrUserService.save(usrUserSaveRequestDto);
//
//        return ResponseEntity.ok(RestResponse.of(usrUserDto));
//    }

    @Operation(tags = "User Controller")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        usrUserService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @Operation(tags = "User Controller")
    @PutMapping
    public ResponseEntity update(@RequestBody UsrUserUpdateRequestDto usrUserUpdateRequestDto) {

        UsrUserDto usrUserDto = usrUserService.update(usrUserUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }

}
