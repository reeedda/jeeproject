package com.example.jeeproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Enable CSRF protection with default configuration
                //.csrf(Customizer.withDefaults())
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/new_recipe", "/available_recipes", "/save",
                                "/favorit","/mylist/{id}","/editRecette/{id}","/deleteRecette/{id}")
                        .authenticated()
                        .requestMatchers("/home", "/" ,"/food3.jpg","/login","/bg2.jpg","/food2.jpg", "/right_img.png" ,"/MyRecipes" )
                        .permitAll())



                //.formLogin(Customizer.withDefaults())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Specify your login page URL
                        .permitAll() // Allow access to the login page without authentication
                        .defaultSuccessUrl("/MyRecipes"))
                .httpBasic(Customizer.withDefaults());

        //Customizer.withDefaults()

        return http.build();
    }





    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/admin/**").hasRole("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // Specify your login page URL
                        .permitAll() // Allow access to the login page without authentication
                        .defaultSuccessUrl("/home"));

        return http.build();
    }*/

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password("admin")
                .roles("admin")
                .build();
        UserDetails user = User.withUsername("user")
                .password("user")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }




}
