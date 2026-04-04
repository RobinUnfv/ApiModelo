package com.robin.demo.taller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests( http -> {
                    // CONFIGURAR LOS ENDPOINTS PUBLICOS
                   http.requestMatchers(HttpMethod.GET, "/api/arfadoc/v1/id").permitAll();
                   http.requestMatchers(HttpMethod.GET, "/api/usuario/id").permitAll();

                   // CONFIGURAR LOS ENDPOINTS PROTEGIDOS O PRIVADOS
                   http.requestMatchers(HttpMethod.GET, "/api/arfadoc/v1/buscar").hasAuthority("CREATE");

                   // CONFIGURAR EL RESTO DE ENDPOINTS - NO ESPECIFICADOS
                   //http.anyRequest().denyAll(); // RECHAZAR A TODOS
                    http.anyRequest().authenticated(); // DEBE DE ESTA AUTENTICADO
                })
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        List<UserDetails> users = new ArrayList<>();
        users.add(User.withUsername("ROBIN")
                .password("1234")
                .roles("ADMIN")
                .authorities("READ", "CREATE")
                .build()
        );

        users.add(User.withUsername("GENESIS")
                .password("448366")
                .roles("USER")
                .authorities("READ")
                .build()
        );
       return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
