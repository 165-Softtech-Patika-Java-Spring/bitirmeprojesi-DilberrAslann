package com.dilberaslan.graduationProject.graduationProject.usr.controller;

import com.dilberaslan.graduationProject.graduationProject.gen.dto.RestResponse;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserDto;
import com.dilberaslan.graduationProject.graduationProject.usr.dto.UsrUserUpdateRequestDto;
import com.dilberaslan.graduationProject.graduationProject.usr.service.UsrUserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dilber
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsrUserController {
    private final UsrUserService usrUserService;

    @Operation(tags = "User Controller", summary = "Delete User")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        usrUserService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @Operation(tags = "User Controller", summary = "Update User")
    @PutMapping
    public ResponseEntity update(@RequestBody UsrUserUpdateRequestDto usrUserUpdateRequestDto) {

        UsrUserDto usrUserDto = usrUserService.update(usrUserUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(usrUserDto));
    }

}
