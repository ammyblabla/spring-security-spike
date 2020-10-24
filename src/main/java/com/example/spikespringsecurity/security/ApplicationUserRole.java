package com.example.spikespringsecurity.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.example.spikespringsecurity.security.ApplicationUserPermission.*;

@Getter
@AllArgsConstructor
public enum  ApplicationUserRole {
  STUDENT(new HashSet<>()),
  ADMIN(createApplicationUserPermissionSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
  ADMINTRAINEE(createApplicationUserPermissionSet(COURSE_READ, STUDENT_READ));

  private final Set<ApplicationUserPermission> permissions;

  private static Set<ApplicationUserPermission> createApplicationUserPermissionSet(ApplicationUserPermission... applicationUserPermissions) {
    return new HashSet<>(Arrays.asList(applicationUserPermissions));
  }
}
