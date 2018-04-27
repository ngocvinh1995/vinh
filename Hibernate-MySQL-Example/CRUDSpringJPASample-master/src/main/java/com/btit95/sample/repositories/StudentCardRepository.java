package com.btit95.sample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.btit95.sample.entities.StudentCard;

public interface StudentCardRepository extends CrudRepository<StudentCard, Integer> {

}
