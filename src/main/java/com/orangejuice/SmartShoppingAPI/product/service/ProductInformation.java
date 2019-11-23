package com.orangejuice.SmartShoppingAPI.product.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Builder
public class ProductInformation {
    @JsonProperty
    private String items;
//    @JsonProperty
//    private String id;
//    @JsonProperty
//    private String name;
}
