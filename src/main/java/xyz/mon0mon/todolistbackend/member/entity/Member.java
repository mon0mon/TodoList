package xyz.mon0mon.todolistbackend.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import xyz.mon0mon.todolistbackend.core.entities.BaseTimeEntity;
import xyz.mon0mon.todolistbackend.member.conveter.OAuthActiveConverter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "member")
@EntityListeners(AuditingEntityListener.class)
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 255)
    @Default
    private String email = "";

    @Column(name = "mobile", length = 15)
    @Default
    private String mobile = "";

    @Column(name = "name", length = 20)
    @Default
    private String name = "";

    @Column(name = "profile_pic", length = 500)
    @Default
    private String profilePic = "";

    @Column(name = "oauth_active", nullable = false)
    @Convert(converter = OAuthActiveConverter.class)
    @Default
    private OAuthActive oAuthActive = OAuthActive.NONE;
}
