package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeatType extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "show_id") // This will create a foreign key column show_id
    private Show show;
    private SeatType seatType;

    private double price;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double totalAmount) {
        this.price = totalAmount;
    }
}
