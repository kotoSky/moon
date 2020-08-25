package cn.moon.controller.user;

import cn.base.vo.Result;
import cn.moon.user.entity.User;
import cn.moon.user.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User requestUser, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("username", username);
        queryWrapper.ge("password", requestUser.getPassword());
        User user = userMapper.selectOne(queryWrapper);

        if (user != null) {
            session.setAttribute("user", user);
            return Result.success("请求成功！");
        } else {
            String message = "账号密码错误";
            session.removeAttribute("user");
            return Result.error().msg(message);
        }
    }

    @GetMapping(path = "api/")
    public Result index() {

        System.out.printf("hello");

        return Result.success().data("你好！");
    }

}
