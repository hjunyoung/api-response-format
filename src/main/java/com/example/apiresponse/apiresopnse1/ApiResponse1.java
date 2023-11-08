package com.example.apiresponse.apiresopnse1;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse1 {

    @Builder.Default
    private String status = "success";
    @Builder.Default
    private String message = "";
    private Object result;

}