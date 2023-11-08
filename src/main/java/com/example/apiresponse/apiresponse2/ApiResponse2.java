package com.example.apiresponse.apiresponse2;

import lombok.Builder;
import lombok.Getter;

public class ApiResponse2 {
    private static final String SUCCESS_STATUS = "success";
    private static final String FAIL_STATUS = "fail";
    private static final String ERROR_STATUS = "error";
    @Getter
    @Builder
    public static class SuccessBody<T> {
        @Builder.Default
        private String status = SUCCESS_STATUS;
        @Builder.Default
        private String message = "Success message";
        private T data;
    }

    @Getter
    @Builder
    public static class ErrorBody {
        @Builder.Default
        private String status = ERROR_STATUS;
        @Builder.Default
        private String message = "Error message";
    }

    @Getter
    @Builder
    public static class Fail<E> {
        @Builder.Default
        private String status = FAIL_STATUS;
        @Builder.Default
        private String message = "Fail message";
        private E data;

    }

    /*
    public static class FieldError {
        private String status;
        private String message;
        private List<Error>
    }
    */
}
