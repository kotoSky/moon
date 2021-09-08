package cn.moon.common.vo;

import cn.moon.common.enums.ResultCode;
import lombok.Data;

/**
 * @author kell
 * @date 2020-05-31 11:10
 * 统一返回结果
 */
@Data
public class Result {

    private Boolean success = Boolean.TRUE;

    private Integer code;

    private String msg;

    private Object data;

    // 构造器私有
    private Result() {
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(msg);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setSuccess(Boolean.FALSE);
        result.setCode(ResultCode.ERROR.getCode());
        result.setMsg(ResultCode.ERROR.getMsg());
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setSuccess(Boolean.FALSE);
        result.setCode(ResultCode.ERROR.getCode());
        result.setMsg(msg);
        return result;
    }

    /**
     * 使用链式编程，返回类本身
     **/

    // 自定义返回数据
    public Result data(Object obj) {
        this.setData(obj);
        return this;
    }

    // 自定义状态
    public Result status(ResultCode resultCode) {
        this.setCode(resultCode.getCode());
        this.setMsg(resultCode.getMsg());
        return this;
    }

    // 自定义状态信息
    public Result msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    // 自定义状态码
    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }
}
