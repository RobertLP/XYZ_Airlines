package com.XYZ_Airlines.XYZ_Airlines.models;

import com.XYZ_Airlines.XYZ_Airlines.models.Enum.TravelClass;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Plane
{
    public Plane(){}

    public Plane(int firstRows, int firstRowSeats, int businessRows, int businessRowSeats,
                 int economyRows, int economyRowSeats)
    {
        //SetupSeats(firstRows, firstRowSeats, TravelClass.FIRST);
        //SetupSeats(businessRows, businessRowSeats, TravelClass.BUSINESS);
        //SetupSeats(economyRows, economyRowSeats, TravelClass.ECONOMY);
        fuel = fuelTankSize;
    }

    //private List<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
    //private void SetupSeats(int rows, int seats, TravelClass travelClass)
    //{
    //    for(int r = 0; r < rows; r++)
    //    {
    //        this.seats.add(new ArrayList<Seat>());
    //        ArrayList<Seat> row = this.seats.get(r);
    //        for(int s = 0; s < seats; s++)
    //        {
    //            row.add(new Seat(r, Character.forDigit(s, 65), travelClass));
    //        }
    //    }
    //}


    private int location; // TODO: replace with with world position later
    private double fuelTankSize = 5;
    private double fuel;

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    private void refuel()
    {
        fuel = fuelTankSize;
    }

    private void burnFuel(double amount)
    {
        fuel = fuel -amount < 0 ? 0 : fuel - amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
