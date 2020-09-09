package com.tram.app.query

import com.tram.app.read_model.ProductSummary
import org.springframework.data.jpa.repository.JpaRepository


class GetProductsQuery

interface ProductSummaryRepository:JpaRepository<ProductSummary,String>