package xyz.mon0mon.todolistbackend.list.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.mon0mon.todolistbackend.member.entity.Member;

@Getter
@Setter
@Builder
@Entity(name = "list_participants")
@NoArgsConstructor
@AllArgsConstructor
public class ListParticipants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private List list;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Member.class)
    private Set<Member> users;
}
