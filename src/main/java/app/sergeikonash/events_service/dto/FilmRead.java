package app.sergeikonash.events_service.dto;

import app.sergeikonash.events_service.dto.enums.Status;
import app.sergeikonash.events_service.dto.enums.Type;

public class FilmRead {

    private long id;
    private String uuid;
    private long dt_create;
    private long dt_update;
    private String title;
    private String description;
    private long dt_event;
    private long dt_end_of_sale;
    private Type type;
    private Status status;

    public FilmRead() {
    }

    public FilmRead(long id,
                    String uuid,
                    long dt_create,
                    long dt_update,
                    String title,
                    String description,
                    long dt_event,
                    long dt_end_of_sale,
                    String type,
                    String status) {
        this.id = id;
        this.uuid = uuid;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
        this.title = title;
        this.description = description;
        this.dt_event = dt_event;
        this.dt_end_of_sale = dt_end_of_sale;
        this.type = Type.valueOf(type);
        this.status = Status.valueOf(status);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getDt_create() {
        return dt_create;
    }

    public void setDt_create(long dt_create) {
        this.dt_create = dt_create;
    }

    public long getDt_update() {
        return dt_update;
    }

    public void setDt_update(long dt_update) {
        this.dt_update = dt_update;
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
}
