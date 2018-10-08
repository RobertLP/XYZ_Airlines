package com.XYZ_Airlines.XYZ_Airlines.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long location;
    private String name;

    @OneToMany
    private List<Plane> planeRegister = new ArrayList<>();

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
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

    public int getRegisterPlaneCount()
    {
        return planeRegister.size();
    }
}
