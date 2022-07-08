package app.sergeikonash.events_service.service;

import app.sergeikonash.events_service.dao.api.IFilmDao;
import app.sergeikonash.events_service.dao.entity.Film;
import app.sergeikonash.events_service.dto.FilmCreate;
import app.sergeikonash.events_service.service.api.IEventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FilmService implements IEventService<Film, FilmCreate> {

    private final IFilmDao filmDao;

    public FilmService(IFilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @Override
    public Film createEvent(FilmCreate filmCreate) {
        if (filmCreate.getTitle() == null || filmCreate.getType() == null) {
            throw new IllegalArgumentException("This field cannot be empty");
        }

        Film film = new Film();
        film.setTitle(filmCreate.getTitle());
        film.setDescription(filmCreate.getDescription());
        film.setDt_event(filmCreate.getDt_event());
        film.setDt_end_of_sale(filmCreate.getDt_end_of_sale());
        film.setType(filmCreate.getType());
        film.setStatus(filmCreate.getStatus());
        film.setCountry(filmCreate.getCountry());
        film.setRelease_year(filmCreate.getRelease_year());
        film.setRelease_date(filmCreate.getRelease_date());
        film.setDuration(filmCreate.getDuration());
        film.setDtCreate(LocalDateTime.now());
        film.setDtUpdate(LocalDateTime.now());
        return (Film) this.filmDao.save(film);
    }

    @Override
    public Film getById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Это поле не может быть пустым");
        }

        return this.filmDao
                .findById(id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Не нашли такого события");
                });
    }

    @Override
    public Film editById(FilmCreate toEdit, Long id, LocalDateTime dtUpdate) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Это поле не может быть пустым");
        }

        Film film = this.getById(id);

        if(!film.getDtUpdate().equals(dtUpdate)){
            throw new IllegalArgumentException("Событие уже было обновлено кем-то ранее");
        }

        film.setTitle(toEdit.getTitle());
        film.setDescription(toEdit.getDescription());
        film.setDt_event(toEdit.getDt_event());
        film.setDt_end_of_sale(toEdit.getDt_end_of_sale());
        film.setType(toEdit.getType());
        film.setStatus(toEdit.getStatus());
        film.setCountry(toEdit.getCountry());
        film.setRelease_year(toEdit.getRelease_year());
        film.setRelease_date(toEdit.getRelease_date());
        film.setDuration(toEdit.getDuration());
        film.setDtUpdate(LocalDateTime.now());
        this.filmDao.save(film);

        return this.getById(id);
    }

    @Override
    public List<Film> getAll() {
        return this.filmDao.findAll();
    }

    @Override
    public List<Film> getAll(String title) {
        return this.filmDao.findByTitle(title);
    }
}
