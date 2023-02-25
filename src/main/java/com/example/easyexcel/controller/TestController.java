package com.example.easyexcel.controller;

import com.example.easyexcel.entity.UserTestEntity;
import com.example.easyexcel.utils.R;
import com.example.easyexcel.utils.R2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述信息
 *
 * @author yzp
 * @since 2023-02-25 12:07
 * @version 1
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/hello1")
    public R<Object> hello() {
        return R.ok();
    }

    @GetMapping("/hello2")
    public R2<UserTestEntity> hello2() {
        return R2.ok(new UserTestEntity("张三", 1)).put("data2", "1");
    }
}
