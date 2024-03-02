package xyz.mon0mon.todolistbackend.item.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.mon0mon.todolistbackend.alarm.entities.Alarm;
import xyz.mon0mon.todolistbackend.core.entities.BaseTimeEntity;
import xyz.mon0mon.todolistbackend.list.entity.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_idx", nullable = false)
    private Short order;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "id")
    private Alarm alarm;

    @ManyToOne(fetch = FetchType.LAZY)
    private List list;

    @Column(name = "content", nullable = false, length = 1200)
    private String content;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Column(name = "child")
    private Set<Item> childes;

    @CreatedBy
    private UserDetails createdBy;

    @LastModifiedBy
    private UserDetails lastModifiedBy;
}