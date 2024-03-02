package xyz.mon0mon.todolistbackend.core.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
public class BaseInviteDto {
    private UserDetails host;

    private List<UserDetails> guests;
}
