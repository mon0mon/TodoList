package xyz.mon0mon.todolistbackend.list.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.mon0mon.todolistbackend.list.entity.List;

public interface ListRepository extends JpaRepository<List, Long> {
}
