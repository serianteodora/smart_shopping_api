package com.orangejuice.SmartShoppingAPI.product.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Builder
public class ProductInformation {
    private String id;
    private String name;
}
