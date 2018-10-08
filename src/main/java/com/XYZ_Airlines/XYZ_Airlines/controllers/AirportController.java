package com.XYZ_Airlines.XYZ_Airlines.controllers;

import com.XYZ_Airlines.XYZ_Airlines.models.Airport;
import com.XYZ_Airlines.XYZ_Airlines.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("airport/")
public class AirportController
{
    @Autowired
    private AirportRepository airportRepository;

    // GET: Returns all airports
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Airport> getAll() {
        return airportRepository.findAll();
    }

    // POST: that saves airport in DB
    @RequestMapping(method = RequestMethod.POST)
    public Airport create(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    // GET: request that returns one airports
    @RequestMapping(value = "{location}", method = RequestMethod.GET)
    public Optional<Airport> findById(@PathVariable long location) {
        Optional<Airport> result = airportRepository.findById(location);
        return result;
    }

    // UPDATE: updates airport in DB
    @RequestMapping(value = "{location}/{name}", method = RequestMethod.PUT)
    public Airport updateById(@PathVariable long location, @PathVariable String name, @RequestBody Airport update) {
        if(airportRepository.existsById(location)){
            update.setLocation(location);
            update.setName(name);
            return airportRepository.save(update);
        } else {
            throw new RuntimeException();
        }
    }

    // DELETE: deletes airport in DB
    @RequestMapping(value = "{location}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable long location) {
        this.airportRepository.deleteById(location);
    }
}
