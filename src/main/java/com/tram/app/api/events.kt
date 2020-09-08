package com.tram.app.api

import java.util.*

data class CreateOrderEvent (
        val orderId: UUID,
        val price: Double,
        val number: Int,
        val productId: String
)

data class AddProductEvent (
        val id: String,
        val price: Double,
        val stock: Int,
        val description: String
)

data class UpdateStockEvent (
        val id: String,
        val stock: Int
)