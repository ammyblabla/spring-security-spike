package com.example.spikespringsecurity.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/v1/students")
@RequiredArgsConstructor
public class StudentManagementController {
  private final StudentRepository studentRepository;

  @GetMapping
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @PostMapping
  public void registerNewStudent(@RequestBody Student student) {
    studentRepository.save(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable Integer studentId) {
    studentRepository.deleteById(studentId);
  }

  @PutMapping(path = "{studentId}")
  public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
    studentRepository.save(student);
  }
}
