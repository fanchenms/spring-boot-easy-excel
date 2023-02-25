package com.example.easyexcel.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 描述信息
 *
 * @author yzp
 * @since 2023-02-25 12:21
 * @version 1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    private int code;
    private String message;
    private T data;

    public static <T> R<T> ok(int code, String message, T data) {
        return new R<>(code, message, data);
    }

    public static <T> R<T> ok(int code, String message) {
        return ok(code, message, null);
    }

    public static <T> R<T> ok(String message) {
        return ok(HttpStatus.OK.value(), message, null);
    }

    public static <T> R<T> ok(T data) {
        return ok(HttpStatus.OK.value(), "success", data);
    }

    public static <T> R<T> ok() {
        return ok(HttpStatus.OK.value(), "success", null);
    }

    public static <T> R<T> error(int code, String message, T data) {
        return new R<>(code, message, data);
    }

    public static <T> R<T> error(int code, String message) {
        return error(code, message, null);
    }

    public static <T> R<T> error(String message) {
        return error(HttpStatus.BAD_REQUEST.value(), message, null);
    }

    public static <T> R<T> error(T data) {
        return error(HttpStatus.BAD_REQUEST.value(), "error", data);
    }

    public static <T> R<T> error() {
        return error(HttpStatus.BAD_REQUEST.value(), "error", null);
    }
}
