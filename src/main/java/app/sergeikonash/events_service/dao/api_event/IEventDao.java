package app.sergeikonash.events_service.dao.api_event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEventDao<T> extends JpaRepository<T, Long> {
    @Query
    List<T> findByTitle(String title);
}