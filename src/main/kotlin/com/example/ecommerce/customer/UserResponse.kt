package com.example.ecommerce.customer

data class UserResponse(
    val id: Long,
    val username: String,
    val email: String
)


fun UserResponse.toResponse() =  UserResponse(
    id = id,
    username = username,
    email = email
)