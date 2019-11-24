package com.orangejuice.SmartShoppingAPI.product.service;

import org.springframework.stereotype.Service;


@Service
public interface ProductService {
    String getProductInformation(String product);

    String getProductCategories();

    String getStoresForProductsByLatLon(String lat, String lon, String buffer, String csvProdId);

    String getApis();
}
