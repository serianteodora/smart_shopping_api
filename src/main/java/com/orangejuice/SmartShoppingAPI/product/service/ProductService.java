package com.orangejuice.SmartShoppingAPI.product.service;

import org.springframework.stereotype.Service;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Service
public interface ProductService {
    List<ProductInformation> getProductInformation(String product) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException;

    String getApis();
}
