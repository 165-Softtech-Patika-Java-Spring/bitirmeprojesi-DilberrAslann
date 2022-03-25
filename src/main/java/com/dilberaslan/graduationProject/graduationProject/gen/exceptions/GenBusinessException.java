package com.dilberaslan.graduationProject.graduationProject.gen.exceptions;

import com.dilberaslan.graduationProject.graduationProject.gen.enums.BaseErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Dilber
 */

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class GenBusinessException extends RuntimeException {

    private BaseErrorMessage baseErrorMessage;
}
