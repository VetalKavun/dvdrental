package com.example.dvdrental.domain;

import java.time.LocalDateTime;

public class City {

    private int cityId;
    private String city;
    private int countryId;
    private LocalDateTime lastUpdate;

    public City(int cityId, String city, int countryId, LocalDateTime lastUpdate) {
        this.cityId = cityId;
        this.city = city;
        this.countryId = countryId;
        this.lastUpdate = lastUpdate;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                ", countryId=" + countryId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
