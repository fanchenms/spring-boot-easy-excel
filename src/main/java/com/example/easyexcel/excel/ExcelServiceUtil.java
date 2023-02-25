package com.example.easyexcel.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;

import java.io.InputStream;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 17:29
 */
public class ExcelServiceUtil {
    public static <T> void read(String fileName, Class<T> clz, AnalysisEventListener<T> readListener) {
        EasyExcel.read(fileName, clz, readListener).sheet().doRead();
    }

    public static <T> void read(String fileName, Class<T> clz, AnalysisEventListener<T> readListener, String sheetName) {
        EasyExcel.read(fileName, clz, readListener).sheet(sheetName).doRead();
    }

    public static <T> void read(String fileName, Class<T> clz, AnalysisEventListener<T> readListener, Integer sheetNo) {
        EasyExcel.read(fileName, clz, readListener).sheet(sheetNo).doRead();
    }

    public static <T> void read(InputStream inputStream, Class<T> clz, AnalysisEventListener<T> readListener) {
        EasyExcel.read(inputStream, clz, readListener).sheet().doRead();
    }

    public static <T> void read(InputStream inputStream, Class<T> clz, AnalysisEventListener<T> readListener, String sheetName) {
        EasyExcel.read(inputStream, clz, readListener).sheet(sheetName).doRead();
    }

    public static <T> void read(InputStream inputStream, Class<T> clz, AnalysisEventListener<T> readListener, Integer sheetNo) {
        EasyExcel.read(inputStream, clz, readListener).sheet(sheetNo).doRead();
    }
}
