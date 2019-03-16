package com.hellokoding.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hellokoding.auth.service.BeanInterfaceDependencyImpl;
import com.hellokoding.auth.service.BeanInterfaceDependencyImplDependsOn;
import com.hellokoding.auth.service.BeanInterfaceImpl;
import com.hellokoding.auth.service.BeanInterfaceImplDependsOn;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    @DependsOn({"beanInterfaceDependencyImplDependsOn"})
    @Lazy
    public BeanInterfaceImplDependsOn beanInterfaceImplDependsOn() {
    	BeanInterfaceImplDependsOn bf = new BeanInterfaceImplDependsOn();
    	bf.setBeanInterfaceDependencyImplDependsOn(beanInterfaceDependencyImplDependsOn());
    	return bf;
    }
    
    @Bean(name="beanInterfaceDependencyImplDependsOn")
    public BeanInterfaceDependencyImplDependsOn beanInterfaceDependencyImplDependsOn() {
    	return new BeanInterfaceDependencyImplDependsOn();
    }
    
    @Bean(initMethod="init", destroyMethod="destory")
    public BeanInterfaceImpl beanInterfaceImpl() {
    	return new BeanInterfaceImpl(beanInterfaceDependencyImpl());
    }
    
    @Bean
    public BeanInterfaceDependencyImpl beanInterfaceDependencyImpl() {
    	return new BeanInterfaceDependencyImpl();
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
    /**
     *  belos is the security mapping
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/resources/**", "/registration","/username").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}