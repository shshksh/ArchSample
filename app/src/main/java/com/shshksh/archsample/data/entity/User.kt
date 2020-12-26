package com.shshksh.archsample.data.entity

data class User(
    private val id: Long,
    private val name: String,
    private val username: String,
    private val email: String,
    private val address: Address,
    private val phone: String,
    private val website: String,
    private val company: Company,
)