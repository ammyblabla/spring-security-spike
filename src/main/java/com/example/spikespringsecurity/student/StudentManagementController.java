package com.example.spikespringsecurity.student;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/v1/students")
@RequiredArgsConstructor
public class StudentManagementController {
  private final StudentRepository studentRepository;

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  @GetMapping
  public List<Student> getAllStudents() {
    System.out.println("get all student");
    return studentRepository.findAll();
  }

  @PreAuthorize("hasAuthority('student:write')")
  @PostMapping
  public void registerNewStudent(@RequestBody Student student) {
    studentRepository.save(student);
  }

  @PreAuthorize("hasAuthority('student:write')")
  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable Integer studentId) {
    studentRepository.deleteById(studentId);
  }

  @PutMapping(path = "{studentId}")
  public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
    studentRepository.save(student);
  }
}
