package com.bookmarket.extensions

import com.bookmarket.dtos.requests.CreateCustomerRequest
import com.bookmarket.dtos.requests.UpdateCustomerRequest
import com.bookmarket.models.CustomerModel

fun CreateCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun UpdateCustomerRequest.toCustomerModel(id: Long): CustomerModel {
    return CustomerModel(id= id, name = this.name, email = this.email)
}