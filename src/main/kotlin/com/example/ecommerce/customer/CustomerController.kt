package com.example.ecommerce.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/customers")
class CustomerController(
    @Autowired
    var customerService: CustomerService
) {

    @GetMapping("/user")
    fun getCustomer(@RequestBody value:String): CustomerEntity{
        return customerService.getCustomer(value)
    }
}