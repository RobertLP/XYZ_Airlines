package com.XYZ_Airlines.XYZ_Airlines.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int location;
    private String name;

    private List<Plane> planeRegister = new ArrayList<>();

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void addPlaneEntry(Plane plane)
    {
        planeRegister.add(plane);
    }

    private void removePlaneEntry(Plane plane)
    {
        planeRegister.remove(plane);
    }

    private int getRegisterPlaneCount()
    {
        return planeRegister.size();
    }
}
