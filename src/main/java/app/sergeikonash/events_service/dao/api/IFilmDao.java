package app.sergeikonash.events_service.dao.api;

import app.sergeikonash.events_service.dao.api_event.IEventDao;
import app.sergeikonash.events_service.dao.entity.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFilmDao extends IEventDao<Film> {
    @Query
    List<Film> findByTitle(String title);
}
