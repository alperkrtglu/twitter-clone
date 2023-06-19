package tweetservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import tweetservice.security.MockAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .addFilterAfter(mockAuthenticationFilter(), BasicAuthenticationFilter.class)
                .csrf().disable()
                .build();
    }

    @Bean
    public MockAuthenticationFilter mockAuthenticationFilter() {
        return new MockAuthenticationFilter();
    }
}
