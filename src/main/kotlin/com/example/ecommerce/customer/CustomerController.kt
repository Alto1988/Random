package com.example.ecommerce.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/customers")
class CustomerController(
    @Autowired
    var customerService: CustomerService
) {

    @GetMapping("/user")
    fun getCustomer(@RequestBody userName:String): CustomerEntity{
        return customerService.getCustomer(userName)
    }



    @PostMapping("/user")
    fun createCustomer(@RequestBody userBody:CustomerEntity) {
        return customerService.createCustomer(userBody)
    }
}