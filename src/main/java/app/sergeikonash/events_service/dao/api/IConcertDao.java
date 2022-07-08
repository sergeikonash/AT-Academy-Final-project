package app.sergeikonash.events_service.dao.api;

import app.sergeikonash.events_service.dao.api_event.IEventDao;
import app.sergeikonash.events_service.dao.entity.Concert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConcertDao extends IEventDao<Concert> {
    @Query
    List<Concert> findByTitle(String title);
}
