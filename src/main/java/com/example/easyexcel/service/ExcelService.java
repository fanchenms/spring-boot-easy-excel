package com.example.easyexcel.service;

import java.io.InputStream;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 21:12
 */
public interface ExcelService {

    /**
     * 导入
     *
     * @param inputStream 文件流
     * @param sheetName 表格sheet名称
     */
    void importer(InputStream inputStream, String sheetName);

    /**
     * 导入类型
     *
     * @return
     */
    String importType();
}
