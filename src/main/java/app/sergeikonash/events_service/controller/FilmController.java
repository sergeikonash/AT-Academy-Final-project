package app.sergeikonash.events_service.controller;

import app.sergeikonash.events_service.dao.entity.Film;
import app.sergeikonash.events_service.dto.FilmCreate;
import app.sergeikonash.events_service.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/afisha/event/films")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public Film createEvent(@RequestBody FilmCreate toCreateDto){
        return (Film) this.filmService.createEvent(toCreateDto);
    }

    @GetMapping
    public List<Film> getPageOfEvents(@PathVariable Long uuid) {
        return null;
    }

    @GetMapping
    public Film getEventById(@PathVariable Long id) {
        return  filmService.getById(id);
    }
}
