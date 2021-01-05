package com.example.dvdrental.domain;

import java.time.LocalDateTime;

public class Country {

    private int countryId;
    private String country;
    private LocalDateTime lastUpdate;

    public Country(int countryId, String country, LocalDateTime lastUpdate) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", country='" + country + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
