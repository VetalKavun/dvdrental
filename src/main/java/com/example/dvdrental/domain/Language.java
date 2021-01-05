package com.example.dvdrental.domain;

import java.time.LocalDateTime;

public class Language {

    private int languageId;
    private String name;
    private LocalDateTime lastUpdate;

    public Language(int languageId, String name, LocalDateTime lastUpdate) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
