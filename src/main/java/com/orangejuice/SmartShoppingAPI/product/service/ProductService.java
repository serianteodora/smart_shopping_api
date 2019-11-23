package com.orangejuice.SmartShoppingAPI.product.service;

import org.springframework.stereotype.Service;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


@Service
public interface ProductService {
    String getProductInformation(String product) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException;

    String getApis();
}
