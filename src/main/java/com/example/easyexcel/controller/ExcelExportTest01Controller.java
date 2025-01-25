package com.example.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.example.easyexcel.excel.export.entity.DemoData;
import com.example.easyexcel.utils.AnnotationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 描述信息: Excel导出测试
 *
 * @author yzp
 * @version 1
 * @since 2025-01-07 0:01
 */
@Slf4j
@RestController
@RequestMapping("/excel/export/")
public class ExcelExportTest01Controller {

    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 直接写即可
     */
    @GetMapping("test1")
    public void simpleWrite() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = /*TestFileUtil.getPath() +*/ "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });

//        // 写法2
//        fileName = /*TestFileUtil.getPath() +*/ "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
//
//        // 写法3
//        fileName = /*TestFileUtil.getPath() +*/ "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写
//        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
//            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//            excelWriter.write(data(), writeSheet);
//        }
    }

    @GetMapping("/test01")
    public void test01(Integer flag) {
        if (flag == 0 || flag == 1 || flag == 2 || flag == 3) {
            String pre = "test";
            for (int i = 0; i < 4; i++) {
                String fileName = pre + (i + 1);
                if (i < flag) {
                    try {
                        int finalI = i;
                        AnnotationUtils.modifyFiled(DemoData.class, map -> map.put("value", new String[]{"新表头名"+(finalI +1)}), fileName);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        AnnotationUtils.modifyFiled(DemoData.class, map -> map.put("value", new String[]{" "}), fileName);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            String fileName = /*TestFileUtil.getPath() +*/ "simpleWrite" + System.currentTimeMillis() + ".xlsx";
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            // 如果这里想使用03 则 传入excelType参数即可
            EasyExcel.write(fileName, DemoData.class)
                    .sheet("模板")
                    .doWrite(() -> {
                        // 分页查询数据
                        return data();
                    });
        } else {
            String fileName = /*TestFileUtil.getPath() +*/ "simpleWrite" + System.currentTimeMillis() + ".xlsx";
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            // 如果这里想使用03 则 传入excelType参数即可
            EasyExcel.write(fileName, DemoData.class)
                    .sheet("模板")
                    .doWrite(() -> {
                        // 分页查询数据
                        return data();
                    });
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
//        String pre = "test";
//        for (int i = 0; i < 1; i++) {
//            String fileName = pre + (i + 1);
//            try {
//                ExcelBeanUtils.modifyFiled(DemoData.class, map -> map.put("value", "修改的标题"), fileName);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
        try {
            AnnotationUtils.modifyFiled(DemoData.class, map -> map.put("value", new String[]{"新表头名"}), "doubleData");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String fileName = /*TestFileUtil.getPath() +*/ "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });
    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
