package com.example.dvdrental.domain;

import java.time.LocalDateTime;

public class FilmCategory {

    private int filmId;
    private int categoryId;
    private LocalDateTime lastUpdate;

    public FilmCategory(int filmId, int categoryId, LocalDateTime lastUpdate) {
        this.filmId = filmId;
        this.categoryId = categoryId;
        this.lastUpdate = lastUpdate;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "filmId=" + filmId +
                ", categoryId=" + categoryId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
