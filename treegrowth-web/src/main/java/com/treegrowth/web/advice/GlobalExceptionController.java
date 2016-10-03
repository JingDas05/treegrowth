package com.treegrowth.web.advice;

import com.treegrowth.common.exception.CustomRuntimeException;
import com.treegrowth.common.exception.ExceptionMessage;
import com.treegrowth.service.exception.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@ControllerAdvice(annotations = {RestController.class})
public class GlobalExceptionController {

    @ExceptionHandler(CustomRuntimeException.class)
    @ResponseBody
    public ResponseEntity<ExceptionMessage> serviceException(CustomRuntimeException customException) {
        HttpStatus status = BAD_REQUEST;
        if (customException instanceof ConflictException) {
            status = CONFLICT;
        }
        return ResponseEntity.status(status)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(new ExceptionMessage(customException));
    }

}
