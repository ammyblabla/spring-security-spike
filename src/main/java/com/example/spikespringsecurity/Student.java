package com.example.spikespringsecurity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class Student {
  private final Integer studentId;
  private final String studentName;
}
