package com.example.ecommerce.customer

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customer")
class CustomerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column
    var username: String,

    @Column
    var email: String,

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String
) {


}