package com.wl.ssyx.common.exception;



import com.wl.ssyx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器，处理所有的异常，通过error方法，
 * 打印异常信息并返回错误结果类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //    将返回对象转成json数据，把所有异常进行处理
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail(null);
    }

    /**
     * 自定义异常处理器
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(SsyxException.class)
    public Result Ssyxerror(SsyxException e){
        e.printStackTrace();
        return Result.fail("null");
    }


}

