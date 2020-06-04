package cn.moon.service.controller;

import cn.base.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kell
 * @date 2020-05-31 11:45
 */
@RestController
public class IndexController {

    @GetMapping(path = "/")
    public Result index() {

        System.out.printf("hello");

        return Result.success().data("你好！");
    }
}