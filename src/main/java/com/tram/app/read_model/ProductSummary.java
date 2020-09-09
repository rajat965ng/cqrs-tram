package com.tram.app.read_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSummary {
    @Id
    private String id;
    private Double price;
    private Integer stock;
    private String description;

}
