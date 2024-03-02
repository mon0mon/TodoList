package xyz.mon0mon.todolistbackend.item.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.mon0mon.todolistbackend.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
