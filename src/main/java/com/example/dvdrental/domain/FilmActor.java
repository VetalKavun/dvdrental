package com.example.dvdrental.domain;

import java.time.LocalDateTime;

public class FilmActor {

    private int actorId;
    private int filmId;
    private LocalDateTime lastUpdate;

    public FilmActor(int actorId, int filmId, LocalDateTime lastUpdate) {
        this.actorId = actorId;
        this.filmId = filmId;
        this.lastUpdate = lastUpdate;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "actorId=" + actorId +
                ", filmId=" + filmId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
