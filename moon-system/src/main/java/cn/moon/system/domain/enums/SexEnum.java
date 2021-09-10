package cn.moon.system.domain.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

@Getter
public enum SexEnum implements IEnum<Integer> {

    MAN(1, "男"),
    WOMAN(2, "女");


    SexEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @EnumValue
    private int key;
    private String value;


    @Override
    public Integer getValue() {
        return this.key;
    }
}
