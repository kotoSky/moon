package cn.moon.common.core.domain;

import cn.moon.common.enums.ResultCode;
import lombok.Data;

/**
 * @author kell
 * @date 2020-05-31 11:10
 * 统一返回结果
 */
@Data
public class MsgResult {

    private Boolean success = Boolean.TRUE;

    private Integer code;

    private String msg;

    private Object data;

    // 构造器私有
    private MsgResult() {
    }

    public static MsgResult success() {
        MsgResult msgResult = new MsgResult();
        msgResult.setCode(ResultCode.SUCCESS.getCode());
        msgResult.setMsg(ResultCode.SUCCESS.getMsg());
        return msgResult;
    }

    public static MsgResult success(String msg) {
        MsgResult msgResult = new MsgResult();
        msgResult.setCode(ResultCode.SUCCESS.getCode());
        msgResult.setMsg(msg);
        return msgResult;
    }

    public static MsgResult error() {
        MsgResult msgResult = new MsgResult();
        msgResult.setSuccess(Boolean.FALSE);
        msgResult.setCode(ResultCode.ERROR.getCode());
        msgResult.setMsg(ResultCode.ERROR.getMsg());
        return msgResult;
    }

    public static MsgResult error(String msg) {
        MsgResult msgResult = new MsgResult();
        msgResult.setSuccess(Boolean.FALSE);
        msgResult.setCode(ResultCode.ERROR.getCode());
        msgResult.setMsg(msg);
        return msgResult;
    }

    /**
     * 使用链式编程，返回类本身
     **/

    // 自定义返回数据
    public MsgResult data(Object obj) {
        this.setData(obj);
        return this;
    }

    // 自定义状态
    public MsgResult status(ResultCode resultCode) {
        this.setCode(resultCode.getCode());
        this.setMsg(resultCode.getMsg());
        return this;
    }

    // 自定义状态信息
    public MsgResult msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    // 自定义状态码
    public MsgResult code(Integer code) {
        this.setCode(code);
        return this;
    }
}
