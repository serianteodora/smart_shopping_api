package com.orangejuice.SmartShoppingAPI.product.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Builder
public class ProductInformation {

    @JsonCreator
    public ProductInformation(@JsonProperty("name") String name,
                              @JsonProperty("id") String id) {
        this.name = name;
        this.id = id;
    }

    private String name;
    private String id;
//    @JsonProperty
//    private String id;
//    @JsonProperty
//    private String name;
}
