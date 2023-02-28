package com.example.easyexcel.excel.importer.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.easyexcel.excel.importer.entity.IcWhtReceiptData;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 21:11
 */
@Slf4j
public class IcWhtReceiptListener extends AnalysisEventListener<IcWhtReceiptData> {
    @Override
    public void invoke(IcWhtReceiptData data, AnalysisContext context) {
        log.info("解析到一条数据：{}", data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("解析全部数据结束！");
    }
}
