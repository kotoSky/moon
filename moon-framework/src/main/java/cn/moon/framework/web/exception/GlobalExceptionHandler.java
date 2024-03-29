package cn.moon.framework.web.exception;

import cn.moon.common.enums.ResultCode;
import cn.moon.common.exception.CustomException;
import cn.moon.common.util.ExceptionUtil;
import cn.moon.common.core.domain.MsgResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kell
 * @date 2020-05-31 11:56
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**-- 通用异常处理方法 --**/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public MsgResult error(Exception e) {
        log.error(ExceptionUtil.getMessage(e));
        return MsgResult.error();	// 通用异常结果
    }

    /**-- 指定异常处理方法 --**/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public MsgResult error(NullPointerException e) {
        log.error(ExceptionUtil.getMessage(e));
        return MsgResult.error().status(ResultCode.NULL_POINTER);
    }

    /**-- 自定义定异常处理方法 --**/
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public MsgResult error(CustomException e) {
        log.error(ExceptionUtil.getMessage(e));
        return MsgResult.error().msg(e.getMessage()).code(e.getCode());
    }

}
