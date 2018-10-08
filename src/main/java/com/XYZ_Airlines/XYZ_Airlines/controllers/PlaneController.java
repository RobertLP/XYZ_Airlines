package com.XYZ_Airlines.XYZ_Airlines.controllers;

import com.XYZ_Airlines.XYZ_Airlines.models.Plane;
import com.XYZ_Airlines.XYZ_Airlines.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("plane/")
public class PlaneController
{
    @Autowired
    private PlaneRepository planeRepository;

    // GET: Returns all planes
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Plane> getAll() {
        return planeRepository.findAll();
    }

    // POST: that saves plane in DB
    @RequestMapping(method = RequestMethod.POST)
    public Plane create(@RequestBody Plane plane) {
        return planeRepository.save(plane);
    }

    // GET: request that returns one plane
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Optional<Plane> findById(@PathVariable long id) {
        Optional<Plane> result = planeRepository.findById(id);
        return result;
    }

    // UPDATE: updates plane in DB
    @RequestMapping(value = "{id}", method = RequestMethod.PUT) // TODO: Update location like this needed? Consider...
    public Plane updateById(@PathVariable long id, @RequestBody Plane update) {
        if(planeRepository.existsById(id)){
            update.setId(id);
            //update.setLocation();
            return planeRepository.save(update);
        } else {
            throw new RuntimeException();
        }
    }

    // DELETE: deletes plane in DB
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable long id) {
        this.planeRepository.deleteById(id);
    }
}
