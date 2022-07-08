package app.sergeikonash.events_service.dto;

import app.sergeikonash.events_service.dto.enums.Status;
import app.sergeikonash.events_service.dto.enums.Type;

import java.time.LocalDateTime;

public class ConcertRead {

    private long id;
    private String title;
    private String description;
    private long dt_event;
    private long dt_end_of_sale;
    private Type type;
    private Status status;
    private String category;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    public ConcertRead() {
    }

    public ConcertRead(long id, String title, String description, long dt_event,
                       long dt_end_of_sale, String type, String status, String category,
                       LocalDateTime dtCreate, LocalDateTime dtUpdate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dt_event = dt_event;
        this.dt_end_of_sale = dt_end_of_sale;
        this.type = Type.valueOf(type);
        this.status = Status.valueOf(status);
        this.category = category;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDt_event() {
        return dt_event;
    }

    public void setDt_event(long dt_event) {
        this.dt_event = dt_event;
    }

    public long getDt_end_of_sale() {
        return dt_end_of_sale;
    }

    public void setDt_end_of_sale(long dt_end_of_sale) {
        this.dt_end_of_sale = dt_end_of_sale;
    }

    public String getType() {
        return String.valueOf(type);
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }
}
