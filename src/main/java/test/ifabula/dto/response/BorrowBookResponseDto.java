package test.ifabula.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class BorrowBookResponseDto {
    private Long id;
    private BookResponseDto book;
    private Long userId;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    private LocalDateTime actualReturnDate;
    private boolean isReturn;
}
