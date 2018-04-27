package com.ifi.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ifi.demo.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
