package com.example.easyexcel.excel.importer.listener;

import com.example.easyexcel.excel.importer.entity.TestOneData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2023-03-02 2:46
 */
@Slf4j
@Component
public class TestOneListener extends ImportListener<TestOneData> {
    @Override
    public void batchOperate(List<TestOneData> list) {
        log.info("接收到一批数据：{}", list);
        log.info("每批次大小：{}", getSize());
    }
}
