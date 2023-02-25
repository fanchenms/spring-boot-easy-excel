package com.example.easyexcel.excel.importer.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.easyexcel.excel.importer.entity.WhtInvoiceData;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 21:09
 */
@Slf4j
public class WhtInvoiceListener extends AnalysisEventListener<WhtInvoiceData> {
//    /**
//     * private Dao dao;
//     * spring传入dao操作数据库
//     *
//     * @param dao
//     */
//    public IcWhtReceiptListener(Dao dao) {
//        this.dao = dao;
//    }

    @Override
    public void invoke(WhtInvoiceData data, AnalysisContext context) {
        log.info("解析到一条数据：{}", data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("解析全部数据结束！");
    }
}
