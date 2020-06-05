package cn.moon.user.service;

import cn.moon.user.entity.User;
import cn.moon.user.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean isExist(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("username", username);
        User user = userMapper.selectOne(queryWrapper);
        return null != user;
    }

}
