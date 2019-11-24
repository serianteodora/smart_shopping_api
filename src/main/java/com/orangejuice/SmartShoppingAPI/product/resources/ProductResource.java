package com.orangejuice.SmartShoppingAPI.product.resources;

import com.orangejuice.SmartShoppingAPI.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @GetMapping(value = "/{prodname}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getProductInformation(@PathVariable(name = "prodname", required = false) String productName) {
        return productService.getProductInformation(productName);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getStoresForProductsByLatLon(@RequestParam Map<String, String> customQuery) {
        return productService.getStoresForProductsByLatLon(customQuery.get("lat"), customQuery.get("lon"), customQuery.get("buffer"), customQuery.get("csvprodids"));
    }

    @GetMapping("/productCategories")
    public String getProductCategories() {
        return productService.getProductCategories();
    }
}
