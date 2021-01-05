package com.example.dvdrental.domain;

import java.time.LocalDateTime;

public class FilmText {

    private int filmId;
    private String title;
    private String description;

    public FilmText(int filmId, String title, String description) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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
}
