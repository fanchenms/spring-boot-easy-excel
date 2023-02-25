package com.example.easyexcel.exception;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 22:12
 */
public class EasyExcelException extends RuntimeException {
    private static final long serialVersionUID = -643776112477307832L;
    private final int code;
    private final String message;

    public EasyExcelException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
