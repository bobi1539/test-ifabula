package test.ifabula.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponseDto {
    private String userId;
    private String accountType;
    private String apiKeyName;
    private String apiKey;
}
