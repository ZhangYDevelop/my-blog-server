package com.zy.blog.server.conf.author2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class AuthorResourceService extends ResourceServerConfigurerAdapter {

    @Autowired
    private  TokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/oauth/**", "/api/logout").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/home/**" ).permitAll()
                .antMatchers("/ueditor/ueditorUpload").permitAll()
                .antMatchers("/ueditor/jsp/upload").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore)
                .resourceId("oauth-server");

    }

}
