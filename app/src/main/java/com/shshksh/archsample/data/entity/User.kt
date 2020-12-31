package com.shshksh.archsample.data.entity

data class User(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
)

data class Address(
    private val street: String,
    private val suite: String,
    private val city: String,
    private val zipcode: String,
    private val geo: Geo,
) {
    override fun toString(): String {
        return String.format("%s, %s, %s", suite, street, city)
    }
}

data class Company(
    private val name: String,
    private val catchPhrase: String,
    private val bs: String,
)

data class Geo(
    private val lat: String,
    private val lng: String,
)