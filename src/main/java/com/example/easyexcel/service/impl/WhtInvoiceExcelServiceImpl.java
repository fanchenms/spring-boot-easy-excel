package com.example.easyexcel.service.impl;

import com.example.easyexcel.excel.ExcelServiceUtil;
import com.example.easyexcel.excel.importer.entity.WhtInvoiceData;
import com.example.easyexcel.excel.importer.listener.WhtInvoiceListener;
import com.example.easyexcel.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 21:20
 */
@Slf4j
@Service
public class WhtInvoiceExcelServiceImpl implements ExcelService {
    @Override
    public void importer(InputStream inputStream, String sheetName) {
        if (StringUtils.hasText(sheetName)) {
            ExcelServiceUtil.read(inputStream, WhtInvoiceData.class, new WhtInvoiceListener(), sheetName);
        } else {
            ExcelServiceUtil.read(inputStream, WhtInvoiceData.class, new WhtInvoiceListener());
        }
    }

    @Override
    public String importType() {
        return "wht";
    }
}
