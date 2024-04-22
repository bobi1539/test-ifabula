package test.ifabula.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import test.ifabula.contant.GlobalMessage;

@Getter
public class BusinessException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public BusinessException(GlobalMessage globalMessage) {
        super(globalMessage.message);
        this.httpStatus = globalMessage.httpStatus;
        this.message = globalMessage.message;
    }
}
