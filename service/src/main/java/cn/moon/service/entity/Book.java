package cn.moon.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@TableName("book")
public class Book {

    @NotNull(message = "ID不能为空")
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;

    @TableField(value = "cid")
    private Integer cid;

    @TableField(value = "cover")
    String cover;

    @TableField(value = "title")
    String title;

    @TableField(value = "author")
    String author;

    @TableField(value = "date")
    String date;

    @TableField(value = "press")
    String press;

    @TableField(value = "abs")
    String abs;
}
