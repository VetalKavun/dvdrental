package com.example.dvdrental.domain;

import java.sql.Blob;
import java.time.LocalDateTime;

public class Staff {

    private int staffId;
    private String firstName;
    private String lastName;
    private int addressId;
    private Blob picture;
    private String email;
    private int storeId;
    private int active;
    private String userName;
    private String password;
    private LocalDateTime lastUpdate;

    public Staff(int staffId, String firstName, String lastName, int addressId, Blob picture, String email, int storeId, int active, String userName, String password, LocalDateTime lastUpdate) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
        this.picture = picture;
        this.email = email;
        this.storeId = storeId;
        this.active = active;
        this.userName = userName;
        this.password = password;
        this.lastUpdate = lastUpdate;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressId=" + addressId +
                ", picture=" + picture +
                ", email='" + email + '\'' +
                ", storeId=" + storeId +
                ", active=" + active +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
