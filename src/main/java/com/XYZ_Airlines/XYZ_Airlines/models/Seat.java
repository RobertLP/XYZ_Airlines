package com.XYZ_Airlines.XYZ_Airlines.models;

import com.XYZ_Airlines.XYZ_Airlines.models.Enum.TravelClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat
{
    public Seat(int rowNumber, char seat, TravelClass travelClass)
    {
        this.rowNumber = rowNumber;
        this.seat = seat;
        this.travelClass = travelClass;
    }

    private long rowNumber;
    private char seat;
    private TravelClass travelClass;
    private boolean reserved = false;

    public long getRowNumber() {
        return rowNumber;
    }
    public void setRowNumber(long rowNumber) {
        this.rowNumber = rowNumber;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }
    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Id
    public String getSeatId()
    {
        return Long.toString(rowNumber) + seat;
    }
}
