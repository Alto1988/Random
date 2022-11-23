package com.example.ecommerce.customer

data class UserCreateResponse(
    val username: String,
    val email: String
)



fun UserCreateResponse.toEntity() = CustomerEntity(
    username = username,
    email = email,
    password = ""
)
