package xyz.mon0mon.todolistbackend.member.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.mon0mon.todolistbackend.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
