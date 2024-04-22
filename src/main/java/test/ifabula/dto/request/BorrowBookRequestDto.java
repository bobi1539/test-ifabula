package test.ifabula.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.ifabula.contant.ValidationMessage;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BorrowBookRequestDto {

    @NotNull(message = ValidationMessage.BOOK_ID_REQUIRED)
    private Long bookId;

    @NotNull(message = ValidationMessage.USER_ID_REQUIRED)
    private Long userId;

    @NotNull(message = ValidationMessage.RETURN_DATE_REQUIRED)
    private LocalDateTime returnDate;
}
