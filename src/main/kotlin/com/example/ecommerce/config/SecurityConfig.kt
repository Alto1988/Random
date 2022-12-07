package com.example.ecommerce.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {


        @Autowired
        private lateinit var userDetailsService: UserDetailsService

        @Autowired
        private lateinit var passwordEncoder: PasswordEncoder

        @Throws(Exception::class)
        override fun configure(http: HttpSecurity) {
            http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/oauth/token").permitAll()
                .anyRequest().authenticated()
        }

        @Throws(Exception::class)
        override fun configure(auth: AuthenticationManagerBuilder) {
            auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
        }

        @Bean
        @Throws(Exception::class)
        override fun authenticationManagerBean(): AuthenticationManager {
            return super.authenticationManagerBean()
        }

}