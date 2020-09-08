package com.tram.app.api

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

data class CreateOrderCommand (
        @TargetAggregateIdentifier
        val orderId: UUID,
        val price: Double,
        val number: Int,
        val productId: String
)

data class AddProductCommand (
        @TargetAggregateIdentifier
        val id: String,
        val price: Double,
        val stock: Int,
        val description: String
)

data class UpdateStockCommand (
        @TargetAggregateIdentifier
        val id: String,
        val stock: Int
)