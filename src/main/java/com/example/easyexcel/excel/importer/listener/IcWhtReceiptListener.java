package com.example.easyexcel.excel.importer.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.easyexcel.excel.importer.entity.IcWhtReceiptData;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-02-25 21:11
 */
public class IcWhtReceiptListener extends AnalysisEventListener<IcWhtReceiptData> {
    @Override
    public void invoke(IcWhtReceiptData data, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
