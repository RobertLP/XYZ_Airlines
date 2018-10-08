package com.XYZ_Airlines.XYZ_Airlines.repository;

import com.XYZ_Airlines.XYZ_Airlines.models.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long>
{

}
