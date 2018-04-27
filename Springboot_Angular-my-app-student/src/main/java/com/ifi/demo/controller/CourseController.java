package com.ifi.demo.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifi.demo.entities.Course;
import com.ifi.demo.repo.CourseRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/courses")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping()
    public Collection<Course> course() {
        return courseRepository.findAll().stream().collect(Collectors.toList());
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("id") Long id) {
		return courseRepository.findAll().stream().filter(course -> course.getId() == id).findFirst().orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Course saveCourse(@RequestBody Course course) {
		Long nextId = 0L;
		if (courseRepository.findAll().size() != 0) {
			Course lastcouse = courseRepository.findAll().stream().skip(courseRepository.findAll().size() - 1).findFirst().orElse(null);
			nextId = lastcouse.getId() + 1;
		}
		course.setId(nextId);
		courseRepository.save(course);
		return course;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Course updateCourse(@RequestBody Course course) {
		Course modifiedCourse = courseRepository.findAll().stream().filter(cou -> cou.getId() == course.getId()).findFirst().orElse(null);
		modifiedCourse.setName(course.getName());
		courseRepository.save(modifiedCourse);
		return modifiedCourse;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteCourse(@PathVariable Long id) {
		Course deleteCourse = courseRepository.findAll().stream().filter(course -> course.getId() == id).findFirst().orElse(null);
		if (deleteCourse != null) {
			courseRepository.deleteById(id);
			return true;
		} else  {
			return false;
		}
	}
}
