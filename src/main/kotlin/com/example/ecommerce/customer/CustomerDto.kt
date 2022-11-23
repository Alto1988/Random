package com.example.ecommerce.customer

import lombok.Builder

@Builder
class CustomerDto(
) {
    private val username: String = ""
    private val email: String = ""

}