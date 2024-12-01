package com.bookmarket.repositories

import com.bookmarket.models.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerModel, Long> {

    fun findByNameContainingIgnoreCase(name: String): List<CustomerModel>
}