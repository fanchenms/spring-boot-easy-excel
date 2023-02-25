package com.example.easyexcel.controller;

import com.example.easyexcel.exception.EasyExcelException;
import com.example.easyexcel.factory.ExcelServiceFactory;
import com.example.easyexcel.service.ExcelService;
import com.example.easyexcel.utils.R2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 17:27
 */
@Slf4j
@RestController
@RequestMapping("/excel")
public class ExcelController {
    @PostMapping("/import/wht")
    public R2<Object> importer(@RequestParam(value = "file") MultipartFile file,
                               @RequestParam(value = "type") String type,
                               @RequestParam(value = "sheetName", required = false) String sheetName) throws IOException {
        ExcelService excelService = ExcelServiceFactory.instance(type);
        if (Objects.isNull(excelService)) {
            throw new EasyExcelException(HttpStatus.BAD_REQUEST.value(), "未知处理类型，请重新输入type!");
        }
        excelService.importer(file.getInputStream(), sheetName);
        return R2.ok();
    }
}
