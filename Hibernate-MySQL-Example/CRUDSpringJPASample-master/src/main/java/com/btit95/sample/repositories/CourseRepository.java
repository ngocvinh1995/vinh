package com.btit95.sample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.btit95.sample.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
