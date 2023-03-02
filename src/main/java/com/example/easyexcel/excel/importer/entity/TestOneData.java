package com.example.easyexcel.excel.importer.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-03-02 2:45
 */
@Data
public class TestOneData {
    @ExcelProperty("name")
    private String name;
    @ExcelProperty("身高")
    private int height;
}
