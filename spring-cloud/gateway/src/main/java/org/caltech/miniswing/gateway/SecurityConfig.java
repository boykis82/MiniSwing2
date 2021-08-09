package org.caltech.miniswing.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.http.HttpMethod.*;

@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/headerrouting/**").permitAll()
                .pathMatchers("/actuator/**").permitAll()
                .pathMatchers("/eureka/**").permitAll()
                .pathMatchers("/oauth/**").permitAll()

                .pathMatchers(POST, "/customer/**").hasAuthority("SCOPE_swing:write")
                .pathMatchers(DELETE, "/customer/**").hasAuthority("SCOPE_swing:write")
                .pathMatchers(GET, "/customer/**").hasAuthority("SCOPE_swing:read")

                .pathMatchers(POST, "/plm/**").hasAuthority("SCOPE_swing:write")
                .pathMatchers(DELETE, "/plm/**").hasAuthority("SCOPE_swing:write")
                .pathMatchers(GET, "/plm/**").hasAuthority("SCOPE_swing:read")

                .pathMatchers(POST, "/service/**").hasAuthority("SCOPE_swing:write")
                .pathMatchers(DELETE, "/service/**").hasAuthority("SCOPE_swing:write")
                .pathMatchers(GET, "/service/**").hasAuthority("SCOPE_swing:read")

                .pathMatchers(POST, "/product/**").hasAuthority("SCOPE_swing:write")
                .pathMatchers(DELETE, "/product/**").hasAuthority("SCOPE_swing:write")
                .pathMatchers(GET, "/product/**").hasAuthority("SCOPE_swing:read")

                .pathMatchers(GET, "/composite/**").hasAuthority("SCOPE_swing:read")

                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }

}