package test.ifabula.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.ifabula.contant.ValidationMessage;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookRequestDto {

    @NotNull(message = ValidationMessage.TITLE_REQUIRED)
    @NotBlank(message = ValidationMessage.TITLE_REQUIRED)
    private String title;

    @NotNull(message = ValidationMessage.DESCRIPTION_REQUIRED)
    @NotBlank(message = ValidationMessage.DESCRIPTION_REQUIRED)
    private String description;
}
