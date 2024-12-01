package com.bookmarket.services

import com.bookmarket.models.CustomerModel
import com.bookmarket.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {
    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContainingIgnoreCase(it)
        }

        return customerRepository.findAll().toList()
    }

    fun get(id: Long): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun delete(id: Long) {
        if (!customerRepository.existsById(id)) {
            throw Exception()
        }

        customerRepository.deleteById(id)
    }
}