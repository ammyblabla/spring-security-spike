package com.example.spikespringsecurity.student;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class Student {
  @Id
  private Integer studentId;
  private String studentName;
}
