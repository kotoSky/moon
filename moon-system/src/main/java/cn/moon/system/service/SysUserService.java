package cn.moon.system.service;

import cn.moon.system.entity.SysUser;
import cn.moon.system.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    public boolean isExist(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("username", username);
        SysUser user = userMapper.selectOne(queryWrapper);
        return null != user;
    }

}
