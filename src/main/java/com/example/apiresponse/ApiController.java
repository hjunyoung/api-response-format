package com.example.apiresponse;

import com.example.apiresponse.apiresponse2.ApiResponse2;
import com.example.apiresponse.apiresponse2.ApiResponse2.SuccessBody;
import com.example.apiresponse.apiresopnse1.ApiResponse1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @PostMapping("")
    public ResponseEntity<ApiResponse1> test(@RequestBody RequestDto responseDto) {
        ApiResponse1 apiResponse = ApiResponse1.builder()
            .result(responseDto)
            .message("hello")
            .status(responseStatus.SUCCESS.getStatus())
            .build();
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(apiResponse);
    }
    @PostMapping("generic")
    public ResponseEntity<SuccessBody<?>> test2(@RequestBody RequestDto responseDto) {
        SuccessBody<Object> apiResponse = ApiResponse2.SuccessBody
            .builder()
            .message("커스텀 메세지")
            .data(responseDto)
            .status(responseStatus.FAIL.getStatus())
            .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(apiResponse);
    }
}
