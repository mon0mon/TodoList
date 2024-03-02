package xyz.mon0mon.todolistbackend.list.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.mon0mon.todolistbackend.core.entities.BaseTimeEntity;
import xyz.mon0mon.todolistbackend.item.entity.Item;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "list")
@EntityListeners(AuditingEntityListener.class)
public class List extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note", nullable = false, length = 255)
    private String note;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,
            orphanRemoval = true, optional = false)
    private ListParticipants listParticipants;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Item> itemList;

    @CreatedBy
    private UserDetails createdBy;

    @LastModifiedBy
    private UserDetails lastModifiedBy;
}
