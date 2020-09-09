package com.tram.app.controllers;

import com.tram.app.api.AddProductCommand;
import com.tram.app.query.GetProductsQuery;
import com.tram.app.read_model.ProductSummary;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/product")
public class ProductController {

    private CommandGateway commandGateway;
    private QueryGateway queryGateway;

    public ProductController(CommandGateway commandGateway,
                             QueryGateway queryGateway){
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/addProduct")
    public void handle(@RequestBody ProductSummary productSummary) {
        System.out.println(productSummary);
        AddProductCommand cmd = new AddProductCommand(
                productSummary.getId(),
                productSummary.getPrice(),
                productSummary.getStock(),
                productSummary.getDescription()
        );
        commandGateway.sendAndWait(cmd);
    }


    @GetMapping("/list")
    public CompletableFuture<List<ProductSummary>> getProducts(){
        return queryGateway.query(new GetProductsQuery(), ResponseTypes.multipleInstancesOf(ProductSummary.class));
    }
}
