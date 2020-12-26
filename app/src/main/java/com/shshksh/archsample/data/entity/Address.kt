package com.shshksh.archsample.data.entity

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