package com.zy.blog.server.conf.security;

import com.zy.blog.server.conf.support.DefineUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsServices(){
        return new DefineUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsServices())
            .passwordEncoder(passwordEncoder());
}


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
            .csrf().disable()
            .authorizeRequests().antMatchers("/oauth/**", "/api/logout").permitAll()
            .antMatchers("/q").permitAll()
            .antMatchers("/v2/api-docs").permitAll()
            .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/home/**").permitAll()
                .antMatchers("/ueditor/ueditorUpload").permitAll()
                .antMatchers("/ueditor/jsp/upload").permitAll()
            .anyRequest().authenticated()
            .and().formLogin();
    }

}
