package xyz.mon0mon.todolistbackend.alarm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.mon0mon.todolistbackend.alarm.entities.Alarm;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}
