package test.ifabula.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class BaseEntityResponseDto {
    protected Timestamp createdAt;
    protected Long createdBy;
    protected Timestamp updatedAt;
    protected Long updatedBy;
    protected boolean isDeleted;
}
