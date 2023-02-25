package com.example.easyexcel.exception;

import com.example.easyexcel.utils.R2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 21:23
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({EasyExcelException.class})
    public R2<Object> handler(EasyExcelException exception) {
        return R2.error(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler({Throwable.class})
    public R2<Object> handler(Throwable throwable) {
        log.info("GlobalExceptionHandler-未知异常处理: {}", throwable.getMessage());
        throwable.printStackTrace();
        return R2.error();
    }
}
