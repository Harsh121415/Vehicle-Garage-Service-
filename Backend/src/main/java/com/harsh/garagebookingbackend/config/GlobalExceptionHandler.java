package com.harsh.garagebookingbackend.config;
import com.harsh.garagebookingbackend.dto.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ApiResponse handleRuntimeException(RuntimeException ex){
        return new ApiResponse(ex.getMessage(),false,null);
    }
}
