package cn.moon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author kell
 * @date 2020-05-31 11:34
 */
@ComponentScan(basePackages = {"cn.moon.*.controller", "cn.moon.*.service"})
@EnableAutoConfiguration
public class MoonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoonApplication.class, args);
        System.out.printf("=============spring boot启动成功=============");
    }
}
