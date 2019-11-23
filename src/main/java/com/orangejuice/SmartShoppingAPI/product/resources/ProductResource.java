package com.orangejuice.SmartShoppingAPI.product.resources;

import com.orangejuice.SmartShoppingAPI.product.service.ProductInformation;
import com.orangejuice.SmartShoppingAPI.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/{prodname}")
    public List<ProductInformation> getProductInformation(@RequestParam(name = "prodname", required = false, defaultValue = "lapte") String productName) {
        return productService.getProductInformation(productName);
    }
}
