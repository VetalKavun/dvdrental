package com.example.dvdrental.domain;

import java.sql.Date;
import java.time.LocalDateTime;

public class Payment {

    private int paymentId;
    private int customerId;
    private int staffId;
    private int rentalId;
    private int amount;
    private Date paymentDate;
    private LocalDateTime lastUpdate;

    public Payment(int paymentId, int customerId, int staffId, int rentalId, int amount, Date paymentDate, LocalDateTime lastUpdate) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", customerId=" + customerId +
                ", staffId=" + staffId +
                ", rentalId=" + rentalId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
