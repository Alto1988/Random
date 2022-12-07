package com.example.ecommerce.applicationuser

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailServicec : UserDetailsService{

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails{
        val user = User(username, "password", emptyList())
        return user
    }
}