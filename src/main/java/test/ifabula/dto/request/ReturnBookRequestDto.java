package test.ifabula.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.ifabula.contant.ValidationMessage;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReturnBookRequestDto {

    @NotNull(message = ValidationMessage.BORROW_ID_REQUIRED)
    private Long borrowId;
}
