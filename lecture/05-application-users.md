# 05 Application users
- We start with username *user* and generated security password. Spring keep this in memory database. This will be disappeared when stop the server.
- When we have many of user. We keep this on SQL database instead.
- One user have
  - Unique username
  - Encoded password (We don't want to keep raw password)
  - Role/s (Role name)
  - Authorities
  
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
    UserDetails anna = User.builder()
        .username("anna")
// Define the password, encrypt by passwordEncoder
        .password(passwordEncoder.encode("password"))
        .roles("STUDENT")
        .build();
// keep user in memory     
    return new InMemoryUserDetailsManager(anna);
  }
}
```

```java
@Configuration
public class PasswordConfig {
  @Bean
  public PasswordEncoder passwordEncoder() {
// User base64 password encoder
// Strength of encoder: 4-31 (default:10)
    return new BCryptPasswordEncoder(10);
  }
}
```

## Note
More information of password configuration strength [here](https://stackoverflow.com/questions/41542872/why-the-strength-of-bcryptpasswordencoder-is-in-between-4-and-31)