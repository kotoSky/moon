package cn.base.enums;


import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(true,200,"操作成功"),
    ERROR(false,400,"操作失敗"),
    NULL_POINTER(false,401,"空指针异常");

    // 响应是否成功
    private Boolean success;
    // 响应状态码
    private Integer code;
    // 响应信息
    private String msg;

    ResultCode(Boolean success,Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
}
