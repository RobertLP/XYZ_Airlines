package com.XYZ_Airlines.XYZ_Airlines.repository;

import com.XYZ_Airlines.XYZ_Airlines.models.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends CrudRepository<Plane, Long>
{

}
