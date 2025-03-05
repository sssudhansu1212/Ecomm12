package com.example.firstAPI.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDTO {
    private String message;
    private String detail;
    private int errorCode;
}
