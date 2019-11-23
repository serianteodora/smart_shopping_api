package com.orangejuice.SmartShoppingAPI.product.service;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProductService {
    public List<ProductInformation> getProductInformation(String product);

}
