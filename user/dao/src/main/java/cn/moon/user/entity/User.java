package cn.moon.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@TableName("t_user")
public class User {

    @NotNull(message = "ID不能为空")
    @TableId(value = "id", type = IdType.AUTO)
    int id;

    @TableField(value = "userName")
    String username;

    @TableField(value = "password")
    String password;

}
