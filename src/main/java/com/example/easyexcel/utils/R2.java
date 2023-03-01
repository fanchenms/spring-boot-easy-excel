package com.example.easyexcel.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 12:35
 */
public class R2<T> extends HashMap<String, Object> {
    private static final long serialVersionUID = -4269644785681638135L;

    private static <T> R2<T> instance(int code, String message, T data) {
        R2<T> result = new R2<>();
        result.put("code", code);
        result.put("message", message);
        result.put("data", data);
        return result;
    }

    public static <T> R2<T> ok(int code, String message, T data) {
        return instance(code, message, data);
    }

    public static <T> R2<T> ok(int code, String message) {
        return ok(code, message, null);
    }

    public static <T> R2<T> ok(String message) {
        return ok(HttpStatus.OK.value(), message, null);
    }

    public static <T> R2<T> ok(T data) {
        return ok(HttpStatus.OK.value(), "success", data);
    }

    public static <T> R2<T> ok() {
        return ok(HttpStatus.OK.value(), "success", null);
    }

    public static <T> R2<T> ok(Map<String, Object> map) {
        R2<T> result = new R2<>();
        result.putAll(map);
        return result;
    }

    public static <T> R2<T> error(int code, String message, T data) {
        return instance(code, message, data);
    }

    public static <T> R2<T> error(int code, String message) {
        return error(code, message, null);
    }

    public static <T> R2<T> error(String message) {
        return error(HttpStatus.BAD_REQUEST.value(), message, null);
    }

    public static <T> R2<T> error(T data) {
        return error(HttpStatus.BAD_REQUEST.value(), "error", data);
    }

    public static <T> R2<T> error() {
        return error(HttpStatus.BAD_REQUEST.value(), "error", null);
    }

    public static <T> R2<T> error(Map<String, Object> map) {
        R2<T> result = new R2<>();
        result.putAll(map);
        return result;
    }

    @Override
    public R2<T> put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
