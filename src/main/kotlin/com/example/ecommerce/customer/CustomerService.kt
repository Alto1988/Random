package com.example.ecommerce.customer

import com.example.ecommerce.exceptions.InformationAlreadyExistsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CustomerService(
    @Autowired
    var customerRepository: CustomerRepository
) {


    fun getCustomer(userName: String): CustomerEntity {
        return customerRepository.findCustomerEntitiesByUsername(userName)
    }

    fun createCustomer(userBody: CustomerEntity): ResponseEntity.BodyBuilder {
        val checkUserExists: CustomerEntity = customerRepository.findCustomerEntitiesByUsername(userBody.username)
        if (checkUserExists != null) {
            InformationAlreadyExistsException()
            return ResponseEntity.badRequest()
        }

        TODO("Not Implemented Yet!!!")
//        var createdUser: CustomerDto = CustomerDto


    }
}