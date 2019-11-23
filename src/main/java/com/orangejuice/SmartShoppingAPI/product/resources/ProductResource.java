package com.orangejuice.SmartShoppingAPI.product.resources;

import com.orangejuice.SmartShoppingAPI.product.service.ProductInformation;
import com.orangejuice.SmartShoppingAPI.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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
    public List<ProductInformation> getProductInformation(@RequestParam(name = "prodname", required = false, defaultValue = "lapte") String productName) {
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
