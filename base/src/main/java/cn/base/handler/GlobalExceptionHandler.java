package cn.base.handler;

import cn.base.enums.ResultCode;
import cn.base.exception.CustomException;
import cn.base.util.ExceptionUtil;
import cn.base.vo.Result;
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
    public Result error(Exception e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.error();	// 通用异常结果
    }

    /**-- 指定异常处理方法 --**/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result error(NullPointerException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().status(ResultCode.NULL_POINTER);
    }

    /**-- 自定义定异常处理方法 --**/
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result error(CustomException e) {
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().msg(e.getMessage()).code(e.getCode());
    }

}
