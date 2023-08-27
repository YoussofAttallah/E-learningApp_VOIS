package com.example.demo.security;

import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final UserDetailsServiceImpl userService;

    public ApplicationSecurity(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, UserDetailsServiceImpl userService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/css/**", "/js/**").permitAll()
                    .antMatchers(HttpMethod.POST,"/api/user/add").permitAll()
                    .antMatchers(HttpMethod.POST, "/api/login").permitAll()

//                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
//                .formLogin()
//                    .loginProcessingUrl("/api/login")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .logoutUrl("/api/logout")
//                    .permitAll()
//                .and()
//                .httpBasic()
//                .and()
                .csrf().disable();
    }
}
