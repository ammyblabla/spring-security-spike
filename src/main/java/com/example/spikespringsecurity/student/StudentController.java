package com.example.spikespringsecurity.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
  private static final List<Student> STUDENTS = Arrays.asList(
      Student.builder().studentId(1).studentName("James").build(),
      Student.builder().studentId(2).studentName("Maria").build(),
      Student.builder().studentId(3).studentName("Anna").build()
  );

  @GetMapping(path = "/{studentId}")
  public Student getStudent(@PathVariable Integer studentId) {
    return STUDENTS.stream()
        .filter(student -> studentId.equals(student.getStudentId()))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exists"));
  }
}
