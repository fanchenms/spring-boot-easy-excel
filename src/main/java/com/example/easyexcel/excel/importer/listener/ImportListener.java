package com.example.easyexcel.excel.importer.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-03-02 2:13
 */
@Slf4j
public abstract class ImportListener<T> extends AnalysisEventListener<T> {
    private static final int SIZE = 5000;
    private final List<T> list = new ArrayList<>(SIZE);

    @Override
    public void invoke(T data, AnalysisContext context) {
        log.info("解析到一条数据：{}", data);
        list.add(data);
        if (list.size() >= getSize()) {
            batchOperate(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (!list.isEmpty() && getSize() > list.size()) {
            batchOperate(list);
            list.clear();
        }
        log.info("解析数据完成！");
    }

    /**
     * 导入批量操作
     *
     * @param list 导入的本批次数据
     */
    public abstract void batchOperate(List<T> list);

    public int getSize() {
        return SIZE;
    }
}
