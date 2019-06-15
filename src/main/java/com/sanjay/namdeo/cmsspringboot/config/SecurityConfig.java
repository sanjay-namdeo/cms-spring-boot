package com.sanjay.namdeo.cmsspringboot.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);

        UserDetails testUser = userBuilder.username("test").password("test").roles("USER").build();
        UserDetails adminUser = userBuilder.username("admin").password("admin").roles("ADMIN").build();


        return new InMemoryUserDetailsManager(testUser, adminUser);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/customers/**").hasRole("ADMIN")
                .and().csrf().disable().headers().frameOptions().disable();
    }
}
