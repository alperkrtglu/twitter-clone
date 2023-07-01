package tweetservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import tweetservice.security.MockAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests()
                .anyRequest().authenticated().and()
                .oauth2ResourceServer()
                .jwt();
        //    .addFilterAfter(mockAuthenticationFilter(), BasicAuthenticationFilter.class)
        return http.build();
    }

//    @Bean
//    public MockAuthenticationFilter mockAuthenticationFilter() {
//        return new MockAuthenticationFilter();
//    }
}
