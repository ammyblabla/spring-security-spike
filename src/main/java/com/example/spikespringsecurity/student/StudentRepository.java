package com.example.spikespringsecurity.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

  Student findStudentByStudentId(Integer studentId);

  List<Student> findAll();

}
