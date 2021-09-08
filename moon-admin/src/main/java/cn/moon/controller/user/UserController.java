package cn.moon.controller.user;

import cn.moon.common.vo.Result;
import cn.moon.system.entity.SysUser;
import cn.moon.system.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private SysUserMapper userMapper;

    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody SysUser requestUser, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("username", username);
        queryWrapper.ge("password", requestUser.getPassword());
        SysUser user = userMapper.selectOne(queryWrapper);

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
