package com.pankaj.restapidemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pankaj.restapidemo.model.Student;

@RepositoryRestResource
public interface StudentRepository extends CrudRepository<Student, Long> {

}
