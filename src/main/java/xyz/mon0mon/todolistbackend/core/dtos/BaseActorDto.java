package xyz.mon0mon.todolistbackend.core.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
public class BaseActorDto {
    private UserDetails createdBy;
    private UserDetails lastModifiedBy;
}
