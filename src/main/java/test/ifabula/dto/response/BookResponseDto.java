package test.ifabula.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class BookResponseDto extends BaseEntityResponseDto {
    private Long id;
    private String title;
    private String description;
    private boolean isBorrow;
}
