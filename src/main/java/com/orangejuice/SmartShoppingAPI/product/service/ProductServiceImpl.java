package com.orangejuice.SmartShoppingAPI.product.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private String productCatalogUrl;
    private String productCategoriesUrl;
    private String storesByProductUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductServiceImpl(final @Value("${smart.products.catalog.url}") String productCatalogUrl,
                              final @Value("${smart.products.categories.url}") String productCategoriesUrl,
                              final @Value("${smart.stores.products.categories}") String storesByProductUrl,
                              RestTemplateBuilder restTemplateBuilder) {
        this.productCatalogUrl = productCatalogUrl;
        this.productCategoriesUrl = productCategoriesUrl;
        this.storesByProductUrl = storesByProductUrl;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public String getProductInformation(String product) {
        log.debug("Retrieving the product information for {}", product);
        sslConnection();

        String url = productCatalogUrl + "?prodname={product}";

        log.info("The URL for retrieving user information is {}", url);
//        ResponseEntity<List<ProductInformation>> response = this.restTemplate.exchange(url.trim(), HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<ProductInformation>>() {}, product);
//        String response = this.restTemplate.getForObject(url, String.class, product);
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = new JSONObject(response);
//        }catch (JSONException err){
//            err.printStackTrace();
//        }
//        JSONArray resources = jsonObject.getJSONArray("Items");
//        for (int j = 0; j < resources.length(); j++) {
//            JSONObject resource = resources.getJSONObject(j);
//            //JSONObject fields = resource.getJSONObject("fields");
//            System.out.println(resource.get("id"));
//            System.out.println(resource.get("name"));
//        }

        return this.restTemplate.getForObject(url, String.class, product);
    }

    @Override
    public String getProductCategories() {
        log.debug("Retrieving the product categories for ");
        sslConnection();

        String url = productCategoriesUrl;

        log.info("The URL for retrieving user categories is {}", url);

        return this.restTemplate.getForObject(url, String.class);
    }

    @Override
    public String getStoresForProductsByLatLon(String lat, String lon, String buffer, String csvProdId) {
        log.debug("Retrieving the product information");
        sslConnection();

        String url = storesByProductUrl + "?lat={lat}&lon={lon}&buffer={buffer}&csvprodids={csvProdId}&OrderBy=price";

        log.info("The URL for retrieving user information is {}", url);
        return this.restTemplate.getForObject(url, String.class, lat, lon, buffer, csvProdId);
    }


    private void sslConnection() {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = null;
        try {
            sslContext = org.apache.http.ssl.SSLContexts.custom()
                    .loadTrustMaterial(null, acceptingTrustStrategy)
                    .build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            e.printStackTrace();
        }

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);

        this.restTemplate.setRequestFactory(requestFactory);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    public String getApis() {
        String url = "https://api.test.touchpoint.ing.net/apis";
        return this.restTemplate.getForObject(url, String.class);
    }
}
