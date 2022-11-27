package com.example.ecommerce.customer

import com.example.ecommerce.exceptions.InformationAlreadyExistsException
import org.hibernate.annotations.common.util.impl.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService(
    @Autowired
    var customerRepository: CustomerRepository
) {

    private val logger = LoggerFactory.logger(CustomerService::class.java)

    fun getCustomer(userName: String): CustomerEntity {
        return customerRepository.findCustomerEntitiesByUsername(userName)
    }

    fun createCustomer(userBody: CustomerEntity) {
        try {
            val checkUserExists:CustomerEntity = customerRepository.findCustomerEntitiesByUsername(userBody.username)
            if(checkUserExists == null) {
                customerRepository.save(userBody)
            }
        }catch (e:InformationAlreadyExistsException) {
            logger.info("Something was found! {}", e)
        }
    }
}