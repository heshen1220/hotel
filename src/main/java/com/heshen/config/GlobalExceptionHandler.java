package com.heshen.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.net.BindException;

import static com.heshen.config.CommonEnum.BODY_NOT_MATCH;

/**
 * @author tianyuanju
 * @data 2022/3/6 9:17
 */
@Slf4j
@RestControllerAdvice
class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({org.springframework.validation.BindException.class, MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResultBody MethodArgumentNotValidExceptionHandler(Exception e) {
        // 从异常对象中拿到ObjectError对象
        if (e instanceof org.springframework.validation.BindException) {
            org.springframework.validation.BindException bindException = (org.springframework.validation.BindException) e;
            String message = bindException.getBindingResult().getFieldError().getDefaultMessage();
            // 然后提取错误提示信息进行返回
            return ResultBody.error(BODY_NOT_MATCH.getCode(),message);
        }
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            String message = methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage();
            // 然后提取错误提示信息进行返回
            return ResultBody.error(BODY_NOT_MATCH.getCode(),message);
        }
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            String message = constraintViolationException.getMessage();
            return ResultBody.error(BODY_NOT_MATCH.getCode(),message);
            // 然后提取错误提示信息进行返回
        }
        return ResultBody.error(BODY_NOT_MATCH);
    }
    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public ResultBody exceptionHandler(ArithmeticException e) {
        logger.error("发生算数异常！原因是:", e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = ClassCastException.class)
    @ResponseBody
    public ResultBody exceptionHandler(ClassCastException e) {
        logger.error("发生类型转换异常！原因是:", e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseBody
    public ResultBody exceptionHandler(NumberFormatException e) {
        logger.error("发生数字格式化异常！原因是:", e);
        return ResultBody.error(e.getMessage());
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResultBody exceptionHandler(BindException e) {
        logger.error("发生端口占用异常！原因是:", e);
        return ResultBody.error(BODY_NOT_MATCH);
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    @ResponseBody
    public ResultBody exceptionHandler(IndexOutOfBoundsException e) {
        logger.error("发生下标越界异常！原因是:", e);
        return ResultBody.error(BODY_NOT_MATCH);
    }
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(NullPointerException e) {
        logger.error("发生空指针异常！原因是:", e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public ResultBody exceptionHandler(IOException e) {
        logger.error("发生IO异常！原因是:", e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(Exception e) {
        logger.error("服务器异常，请稍后重试", e);
        return ResultBody.error(CommonEnum.NOT_FOUND);
    }

}
