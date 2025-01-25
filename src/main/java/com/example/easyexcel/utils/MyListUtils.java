package com.example.easyexcel.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2025-01-24 23:59
 */
public class MyListUtils {
    private MyListUtils() {
    }

    /**
     * 将大 List 拆分成小 List，每个小 List 包含指定数量的元素
     * @param sourceList 源大 List
     * @param chunkSize  每个小 List 的大小
     * @return 拆分后的 List 的 List
     * @param <T> List的泛型
     */
    public static <T> List<List<T>> splitList(List<T> sourceList, int chunkSize) {
        List<List<T>> result = new ArrayList<>();
        for (int i = 0; i < sourceList.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, sourceList.size());
            result.add(new ArrayList<>(sourceList.subList(i, end)));
        }
        return result;
    }
}
