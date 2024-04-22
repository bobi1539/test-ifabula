package test.ifabula.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import test.ifabula.contant.ValidationMessage;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterRequestDto {

    @NotNull(message = ValidationMessage.EMAIL_REQUIRED)
    @NotBlank(message = ValidationMessage.EMAIL_REQUIRED)
    private String email;

    @NotNull(message = ValidationMessage.PASSWORD_REQUIRED)
    @NotBlank(message = ValidationMessage.PASSWORD_REQUIRED)
    @Length(min = 8, message = ValidationMessage.PASSWORD_MIN)
    private String password;
}
