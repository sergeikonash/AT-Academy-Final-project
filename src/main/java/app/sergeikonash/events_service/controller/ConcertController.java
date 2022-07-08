package app.sergeikonash.events_service.controller;

import app.sergeikonash.events_service.dao.entity.Concert;
import app.sergeikonash.events_service.dto.ConcertCreate;
import app.sergeikonash.events_service.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/api/v1/afisha/event/concerts")
public class ConcertController {

    {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    private final ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    @GetMapping
    public List<Concert> getAll(){
        return this.concertService.getAll();
    }

    @PostMapping
    public ResponseEntity<Concert> createEvent(@RequestBody ConcertCreate dto){
        return new ResponseEntity<>(this.concertService.createEvent(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public Concert editEvent(@PathVariable Long id, @PathVariable Long version, @RequestBody ConcertCreate dto){
        LocalDateTime lastKnowDtUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(version), ZoneId.systemDefault());
        return this.concertService.editById(dto, id, lastKnowDtUpdate);
    }

    @GetMapping
    public Concert getEventById(@PathVariable Long id) {
        return this.concertService.getById(id);
    }
}
