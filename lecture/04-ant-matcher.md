# 04 Ant Matcher
For whitelist specific url, let some url to public
```java
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig  extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
//        Specify whitelist url
        .antMatchers("/", "index", "/css/*", "/js/*")
//        Permit all specific url
        .permitAll()
//        basic authentication
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }
}
```