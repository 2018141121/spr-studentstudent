package com.codel.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
// 实现网络安全配置适配器
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        基于内存的认证
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder())
                //加密
                .withUser("admin")
                .password(bCryptPasswordEncoder().encode("123456"))
                .roles();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
