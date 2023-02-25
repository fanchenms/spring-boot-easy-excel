package com.example.easyexcel.excel.importer.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 20:47
 */
@Data
public class WhtInvoiceData {
    @ExcelProperty("AR公司")
    private String arCompany;

    @ExcelProperty("税码")
    private String taxCode;

    @ExcelProperty("来源")
    private String apSource;

    @ExcelProperty("发票大类")
    private String invoiceType;
}
