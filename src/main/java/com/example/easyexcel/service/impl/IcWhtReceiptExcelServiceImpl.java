package com.example.easyexcel.service.impl;

import com.example.easyexcel.excel.ExcelServiceUtil;
import com.example.easyexcel.excel.importer.entity.IcWhtReceiptData;
import com.example.easyexcel.excel.importer.listener.IcWhtReceiptListener;
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
 * @since 2023-02-25 21:21
 */
@Slf4j
@Service
public class IcWhtReceiptExcelServiceImpl implements ExcelService {
    @Override
    public void importer(InputStream inputStream, String sheetName) {
        if (StringUtils.hasText(sheetName)) {
            ExcelServiceUtil.read(inputStream, IcWhtReceiptData.class, new IcWhtReceiptListener(), sheetName);
        } else {
            ExcelServiceUtil.read(inputStream, IcWhtReceiptData.class, new IcWhtReceiptListener());
        }
    }

    @Override
    public String importType() {
        return "icwht";
    }
}
