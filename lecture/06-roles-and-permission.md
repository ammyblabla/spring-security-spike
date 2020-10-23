# 06 Roles and Permission
![img](resource/06/01.png)
- Roles (ROLE:ADMIN) 
    - = High level view of all user in the system 
    - = Set of permission
- Permissions (STUDENTS:READ, COURSE:WRITE, etc.)
    - What user can do
    
These roles and permission help us to secure our API.

## Admin user
```java
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig  extends WebSecurityConfigurerAdapter {
  private final PasswordEncoder passwordEncoder;
  
  @Override
  @Bean
  protected UserDetailsService userDetailsService() {
// Define user
    UserDetails linda = User.builder()
        .username("linda")
        .password(passwordEncoder.encode("password123"))
// ROLES: ADMIN
        .roles("ADMIN")
        .build();
// keep user in memory     
    return new InMemoryUserDetailsManager(linda);
  }
}
```