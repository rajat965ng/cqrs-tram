package com.tram.app.write_model;

import com.tram.app.api.AddProductCommand;
import com.tram.app.api.AddProductEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Product {
    @AggregateIdentifier
    private String id;
    private Double price;
    private Integer stock;
    private String description;

    public Product() {
    }

    @CommandHandler
    public Product(AddProductCommand cmd) {
        apply(new AddProductEvent(
           cmd.getId(),
           cmd.getPrice(),
           cmd.getStock(),
           cmd.getDescription()
        ));
    }

    @EventSourcingHandler
    public void on(AddProductEvent evt) {
        id = evt.getId();
        price = evt.getPrice();
        stock = evt.getStock();
        description = evt.getDescription();
    }

}
