package com.example.easyexcel.utils;

import com.alibaba.excel.annotation.ExcelProperty;
import org.apache.commons.lang.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 描述信息
 *
 * @author yzp
 * @version 1
 * @since 2025-01-07 20:45
 */
public class AnnotationUtils {
    private AnnotationUtils() {
    }

    /**
     * 修改ExcelProperty注解的value值
     *
     * @param clazz 实体类
     * @param consumer 修改注解的属性。   map -> map.put("value", "值")    map -> map.put("value", new String[]{"值1","值2"})
     * @param fieldName 属性名
     * @throws Exception 抛出异常
     */
    public static void modifyFiled(Class<?> clazz, Consumer<Map<String, Object>> consumer, String fieldName) throws Exception {
        modifyAnnotationFiled(ExcelProperty.class, clazz, consumer, fieldName);
    }

    /**
     * 修改ExcelProperty注解的value值,设置多级表头
     * @param clazz
     * @param title
     * @throws Exception
     */
    public static void reBuildExcelPropertyValue(Class<?> clazz, String title) throws Exception {
        Field[] exportFields = clazz.getDeclaredFields();
        for (Field field : exportFields) {
            ExcelProperty annotation = field.getAnnotation(ExcelProperty.class);
            if (annotation != null) {
                String[] value = annotation.value();
                value[0] = "{%s}";
                if (StringUtils.startsWith(value[0], "{") && StringUtils.endsWith(value[0], "}")) {
                    modifyFiled(clazz, map -> {
                        map.put("value",
                                new String[]{StringUtils.replaceEach(String.format(value[0], title),
                                        new String[]{"{", "}"},
                                        new String[]{"", ""}),
                                        value[1]});
                    }, field.getName());
                }
            }
        }
    }

    /**
     * 修改注解的属性值
     * @param annotationClazz 要修改的注解
     * @param entityClazz 要修改的类（注解在该类的属性上）
     * @param consumer 修改逻辑。例如 map -> map.put("value", "修改后的值")
     * @param fieldName 要修改的注解标注的属性名
     * @throws NoSuchFieldException、IllegalAccessException
     */
    public static void modifyAnnotationFiled(Class<? extends Annotation> annotationClazz, Class<?> entityClazz, Consumer<Map<String, Object>> consumer, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        // 获取需要修改的属性
        Field field = entityClazz.getDeclaredField(fieldName);
        // 获取该属性上的执行注解注解
        Annotation annotation = field.getAnnotation(annotationClazz);
        // 生成代理类对象（注解的代理对象）
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
        // 获取注解的属性
        Field annotationValues = invocationHandler.getClass().getDeclaredField("memberValues");
        // 设置注解属性可访问
        annotationValues.setAccessible(true);
        // 获取注解的属性
        Map map = (Map) annotationValues.get(invocationHandler);
        // 修改注解的属性
        consumer.accept(map);
    }
}
