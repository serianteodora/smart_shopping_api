package com.orangejuice.SmartShoppingAPI.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private String productCatalogUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductServiceImpl(final @Value("${smart.products.catalog.url}") String productCatalogUrl,
                              RestTemplateBuilder restTemplateBuilder) {
        this.productCatalogUrl = productCatalogUrl;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<ProductInformation> getProductInformation(String product) {
        log.debug("Retrieving the product information for {}", product);
        String url = String.format("%s/%s/", productCatalogUrl, product);

        log.debug("The URL for retrieving user information is {}", url);
        ResponseEntity<List<ProductInformation>> response = this.restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ProductInformation>>() {});
        return response.getBody();
    }
}
