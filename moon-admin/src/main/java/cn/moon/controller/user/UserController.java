package cn.moon.controller.user;

import cn.moon.common.core.domain.MsgResult;
import cn.moon.framework.web.service.TokenService;
import cn.moon.system.domain.SysUser;
import cn.moon.system.domain.model.LoginUser;
import cn.moon.system.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private TokenService tokenService;

    @CrossOrigin
    @PostMapping(value = "/login")
    public MsgResult login(LoginUser loginUser, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = loginUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", username);
        queryWrapper.eq("password", loginUser.getPassword());
        SysUser user = userMapper.selectOne(queryWrapper);

        if (user != null) {
            loginUser.setUser(user);
            String token = tokenService.createToken(loginUser);
            return MsgResult.success("请求成功！").data(token);
        } else {
            String message = "账号密码错误";
            session.removeAttribute("user");
            return MsgResult.error().msg(message);
        }
    }

    @GetMapping(path = "/getInfo")
    public MsgResult getInfo(HttpServletRequest request) {

        LoginUser loginUser = tokenService.getLoginUser(request);

        return MsgResult.success().data(loginUser);
    }

}
