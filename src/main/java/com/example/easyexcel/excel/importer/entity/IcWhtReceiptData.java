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
public class IcWhtReceiptData {
    @ExcelProperty("AR公司")
    private String arCompany;

    @ExcelProperty("AP公司")
    private String apCompany;

    @ExcelProperty("税码")
    private String taxCode;

    @ExcelProperty("来源")
    private String apSource;

    @ExcelProperty("发票类型")
    private String invoiceType;

    @ExcelProperty("收款方法")
    private String receiptMethod;

    @ExcelProperty("收款银行")
    private String receiptBank;

    @ExcelProperty("销售员")
    private String salesperson;
}
