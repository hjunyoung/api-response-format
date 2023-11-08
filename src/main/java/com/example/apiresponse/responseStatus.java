package com.example.apiresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum responseStatus {
    SUCCESS("success"), ERROR("error"), FAIL("fail");

    private final String status;
}
