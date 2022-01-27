package com.bootcamps.api.bootcampsplatformapi.repository;

import com.bootcamps.api.bootcampsplatformapi.entity.Bootcamp;
import org.springframework.data.repository.CrudRepository;

public interface BootcampRepository extends CrudRepository<Bootcamp, Long> {
}
