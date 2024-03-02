package xyz.mon0mon.todolistbackend.core.dtos;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseTimeDto {
    LocalDateTime createAt;
    LocalDateTime lastModifiedAt;
}
