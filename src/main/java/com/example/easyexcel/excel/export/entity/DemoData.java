package com.example.easyexcel.excel.export.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2025-01-24 23:59
 */
@Getter
@Setter
@EqualsAndHashCode
@ExcelIgnoreUnannotated
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;

    /**
     * 属性名称和Excel列名相同，则无需设置ExcelProperty注解。 @ExcelProperty(value = "日期标题", index = 1)
     * 属性名第2个字母，最好不要大写，否则会出现一些json序列化的问题，比如 @DateTimeFormat 就会失效
     * 日期格式化：@DateTimeFormat("yyyy-MM-dd")、@DateTimeFormat("yyyy-MM-dd hh:mm:ss")
     * 设置列宽：@ColumnWidth(24)
     */
    @DateTimeFormat("yyyy-MM-dd hh:mm:ss")
    @ExcelProperty("日期标题")
    @ColumnWidth(24)
    private Date date;

    @ExcelProperty("数字标题")
    private Double doubleData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;

    private String ignore2;

    @ExcelProperty(" ")
    private String test1;

    @ExcelProperty(" ")
    private String test2;

    @ExcelProperty(" ")
    private String test3;

    @ExcelProperty(" ")
    private String test4;
}