package cn.moon.user.controller;

import cn.base.vo.Result;
import cn.moon.user.entity.User;
import cn.moon.user.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("username", username);
        User user = userMapper.selectOne(queryWrapper);

        if (Objects.equals(user.getUsername(), username) && Objects.equals(user.getPassword(), requestUser.getPassword())) {
            String message = "账号密码错误";
            return Result.error().msg(message);
        } else {
            return Result.success();
        }
    }

    @GetMapping(path = "api/")
    public Result index() {

        System.out.printf("hello");

        return Result.success().data("你好！");
    }

}
