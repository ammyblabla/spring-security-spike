package com.example.spikespringsecurity.student;

import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/v1/students")
public class StudentManagementController {
  private List<Student> students = Arrays.asList(
      Student.builder().studentId(1).studentName("James").build(),
      Student.builder().studentId(2).studentName("Maria").build(),
      Student.builder().studentId(3).studentName("Anna").build()
  );

  @GetMapping
  public List<Student> getAllStudents() {
    return students;
  }

  @PostMapping
  public void registerNewStudent(@RequestBody Student student) {
    System.out.println(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable Integer studentId) {
    System.out.println(studentId);
  }

  @PutMapping(path = "{studentId}")
  public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
    System.out.println(String.format("%s %s", studentId, student));
  }
}
