package com.example.easyexcel.service.impl;

import com.example.easyexcel.excel.ExcelServiceUtil;
import com.example.easyexcel.excel.importer.entity.TestOneData;
import com.example.easyexcel.excel.importer.listener.TestOneListener;
import com.example.easyexcel.service.ExcelService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-03-02 2:49
 */
@Service
public class TestOneExcelServiceImpl implements ExcelService {
    @Override
    public void importer(InputStream inputStream, String sheetName) {
        if (StringUtils.hasText(sheetName)) {
            ExcelServiceUtil.read(inputStream, TestOneData.class, new TestOneListener(), sheetName);
        } else {
            ExcelServiceUtil.read(inputStream, TestOneData.class, new TestOneListener());
        }
    }

    @Override
    public String importType() {
        return "testOne";
    }
}
