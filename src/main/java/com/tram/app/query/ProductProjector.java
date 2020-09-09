package com.tram.app.query;

import com.tram.app.api.AddProductEvent;
import com.tram.app.read_model.ProductSummary;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProjector {

    private final ProductSummaryRepository productSummaryRepository;

    public ProductProjector(ProductSummaryRepository productSummaryRepository) {
        this.productSummaryRepository = productSummaryRepository;
    }

    @EventHandler
    public void on(AddProductEvent evt){
        ProductSummary summary = new ProductSummary(evt.getId(), evt.getPrice(), evt.getStock(), evt.getDescription());
        productSummaryRepository.save(summary);
    }

    @QueryHandler
    public List<ProductSummary> handle(GetProductsQuery query){
        return productSummaryRepository.findAll();
    }
}
