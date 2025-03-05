package com.example.firstAPI.ControllerAdvices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.firstAPI.DTO.ArithmeticExceptionDTO;
import com.example.firstAPI.DTO.ExceptionDTO;
import com.example.firstAPI.Exceptions.ProductNotFoundException;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDTO> handleArithmaticException(){
        ArithmeticExceptionDTO arithmeticExceptionDTO = new ArithmeticExceptionDTO();
        arithmeticExceptionDTO.setMessage("Something has gone wrong");
        return new ResponseEntity<>(arithmeticExceptionDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException exception){
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage(exception.getMessage());
        dto.setErrorCode(400);
        return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
    }
}
