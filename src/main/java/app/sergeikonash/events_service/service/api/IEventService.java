package app.sergeikonash.events_service.service.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IEventService<T1, T2> {

    T1 createEvent(T2 toCreateDto);

    T1 getById(Long id);

    T1 editById(T2 toEdit, Long id, LocalDateTime dtUpdate);

    List<T1> getAll();

    List<T1> getAll(String name);
}
