package cn.base.exception;

import cn.base.enums.ResultCode;
import lombok.Data;

/**
 * @author kell
 * @date 2020-05-31 12:04
 */
@Data
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(ResultCode resultCodeEnum) {
        super(resultCodeEnum.getMsg());
        this.code = resultCodeEnum.getCode();
    }

}
