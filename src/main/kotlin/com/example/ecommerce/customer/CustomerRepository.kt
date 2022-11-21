package com.example.ecommerce.customer

import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerEntity, Long> {

    fun findCustomerEntitiesByUsernameOrPassword(value: String): CustomerEntity
}