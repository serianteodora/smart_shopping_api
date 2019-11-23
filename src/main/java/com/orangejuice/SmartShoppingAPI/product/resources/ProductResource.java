package com.orangejuice.SmartShoppingAPI.product.resources;

import com.orangejuice.SmartShoppingAPI.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RestController
public class ProductResource {
    private ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String index() {
        return productService.getApis();
    }

    @GetMapping("/{prodname}")
    public String getProductInformation(@PathVariable(name = "prodname", required = false) String productName) {
        try {
            return productService.getProductInformation(productName);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }
}
