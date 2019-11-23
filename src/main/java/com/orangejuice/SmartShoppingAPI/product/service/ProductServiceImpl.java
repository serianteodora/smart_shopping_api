package com.orangejuice.SmartShoppingAPI.product.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Properties;

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
    public String getProductInformation(String product){
        log.debug("Retrieving the product information for {}", product);
//        Properties props = new Properties();
//        props.setProperty("http.proxyHost=giba-proxy.wps.ing.net http.proxyPort=8080");
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = null;
        try {
            sslContext = org.apache.http.ssl.SSLContexts.custom()
                    .loadTrustMaterial(null, acceptingTrustStrategy)
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
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
        //RestTemplate restTemplate = new RestTemplate(requestFactory);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        String url = productCatalogUrl+"?prodname={product}";

        log.info("The URL for retrieving user information is {}", url);
//        ResponseEntity<List<ProductInformation>> response = this.restTemplate.exchange(url.trim(), HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<ProductInformation>>() {}, product);
        return this.restTemplate.getForObject(url, String.class, product);
        //return response.getStatusCode().getReasonPhrase();//.getBody();
    }



    public String getApis() {
        String url = "https://api.test.touchpoint.ing.net/apis";
        return this.restTemplate.getForObject(url, String.class);
    }
}
