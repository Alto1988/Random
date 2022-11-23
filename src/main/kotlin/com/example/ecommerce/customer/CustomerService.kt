package com.example.ecommerce.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService(
    @Autowired
    var customerRepository: CustomerRepository
) {


    fun getCustomer(userName: String): CustomerEntity {
        return customerRepository.findCustomerEntitiesByUsername(userName)
    }
}