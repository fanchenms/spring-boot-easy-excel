package com.example.easyexcel.factory;

import com.example.easyexcel.service.ExcelService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 21:37
 */
@Component
public class ExcelServiceFactory implements ApplicationContextAware {
    private static final Map<String, ExcelService> MAP = new HashMap<>(16);

    public static ExcelService instance(String importType) {
        return MAP.get(importType);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ExcelService> beansOfType = applicationContext.getBeansOfType(ExcelService.class);
        for (Map.Entry<String, ExcelService> entry : beansOfType.entrySet()) {
            ExcelService excelService = entry.getValue();
            MAP.put(excelService.importType(), excelService);
        }
    }
}
