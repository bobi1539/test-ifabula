package test.ifabula.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import test.ifabula.contant.GlobalMessage;
import test.ifabula.dto.response.BaseResponse;

@ControllerAdvice
public abstract class BaseController {

    public static <T> BaseResponse<T> buildSuccessResponse(T object) {
        return BaseResponse.<T>builder()
                .code(GlobalMessage.SUCCESS.httpStatus.value())
                .message(GlobalMessage.SUCCESS.message)
                .data(object)
                .build();
    }
}
