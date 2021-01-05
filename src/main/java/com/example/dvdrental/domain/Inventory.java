package com.example.dvdrental.domain;

import java.time.LocalDateTime;

public class Inventory {

    private int inventoryId;
    private int filmId;
    private int storeId;
    private LocalDateTime lastUpdate;

    public Inventory(int inventoryId, int filmId, int storeId, LocalDateTime lastUpdate) {
        this.inventoryId = inventoryId;
        this.filmId = filmId;
        this.storeId = storeId;
        this.lastUpdate = lastUpdate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", filmId=" + filmId +
                ", storeId=" + storeId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
