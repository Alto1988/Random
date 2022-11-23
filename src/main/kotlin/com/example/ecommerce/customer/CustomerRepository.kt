package com.example.ecommerce.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CustomerRepository : JpaRepository<CustomerEntity, Long> {

//    fun findCustomerEntitiesByUsernameOrPassword(value: String): CustomerEntity

    fun findCustomerEntitiesByUsername(value: String): CustomerEntity
}