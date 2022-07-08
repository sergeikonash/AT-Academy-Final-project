package app.sergeikonash.events_service.service;

import app.sergeikonash.events_service.dao.api.IConcertDao;
import app.sergeikonash.events_service.dao.entity.Concert;
import app.sergeikonash.events_service.dto.ConcertCreate;
import app.sergeikonash.events_service.service.api.IEventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConcertService implements IEventService<Concert, ConcertCreate> {

    private final IConcertDao concertDao;

    public ConcertService(IConcertDao concertDao) {
        this.concertDao = concertDao;
    }

    @Override
    public Concert createEvent(ConcertCreate concertCreate) {

        if (concertCreate.getTitle() == null || concertCreate.getType() == null) {
            throw new IllegalArgumentException("This field cannot be empty");
        }

        Concert concert = new Concert();
        concert.setTitle(concertCreate.getTitle());
        concert.setDescription(concertCreate.getDescription());
        concert.setDt_event(concertCreate.getDt_event());
        concert.setDt_end_of_sale(concertCreate.getDt_end_of_sale());
        concert.setType(concertCreate.getType());
        concert.setStatus(concertCreate.getStatus());
        concert.setCategory(concertCreate.getCategory());
        concert.setDtCreate(LocalDateTime.now());
        concert.setDtUpdate(LocalDateTime.now());
        return (Concert) this.concertDao.save(concert);
    }

    @Override
    public Concert getById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Это поле не может быть пустым");
        }

        return this.concertDao
                .findById(id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Не нашли такого события");
                });
    }

    @Override
    public Concert editById(ConcertCreate toEdit, Long id, LocalDateTime dtUpdate) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Это поле не может быть пустым");
        }

        Concert concert = this.getById(id);

        if(!concert.getDtUpdate().equals(dtUpdate)){
            throw new IllegalArgumentException("Событие уже было обновлено кем-то ранее");
        }

        concert.setTitle(toEdit.getTitle());
        concert.setDescription(toEdit.getDescription());
        concert.setDt_event(toEdit.getDt_event());
        concert.setDt_end_of_sale(toEdit.getDt_end_of_sale());
        concert.setType(toEdit.getType());
        concert.setStatus(toEdit.getStatus());
        concert.setCategory(toEdit.getCategory());
        concert.setDtUpdate(LocalDateTime.now());
        this.concertDao.save(concert);

        return this.getById(id);
    }

    @Override
    public List<Concert> getAll() {
        return this.concertDao.findAll();
    }

    @Override
    public List<Concert> getAll(String title) {
        return this.concertDao.findByTitle(title);
    }
}
