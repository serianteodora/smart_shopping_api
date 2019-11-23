package com.orangejuice.SmartShoppingAPI.product.resources;

import com.orangejuice.SmartShoppingAPI.product.service.ProductInformation;
import com.orangejuice.SmartShoppingAPI.product.service.ProductService;
import com.orangejuice.SmartShoppingAPI.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Controller
public class ProductResource {
    private ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Path("/{apiId}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<ProductInformation> getProductInformation(@RequestParam(name = "prodname", required = false, defaultValue = "Stranger") String productName) {
        return productService.getProductInformation(productName);
    }
}
