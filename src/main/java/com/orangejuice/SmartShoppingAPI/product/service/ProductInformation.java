package com.orangejuice.SmartShoppingAPI.product.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@Builder
public class ProductInformation {

    @JsonCreator
    public ProductInformation(@JsonProperty("Items") String items,
                              @JsonProperty("CatalogProduct") String catalogProduct,
                              @JsonProperty("Id") String id) {
        this.items = items;
        this.catalogProduct = catalogProduct;
        this.id = id;
    }

    private String items;
    private String catalogProduct;
    private String id;
//    @JsonProperty
//    private String id;
//    @JsonProperty
//    private String name;
}
