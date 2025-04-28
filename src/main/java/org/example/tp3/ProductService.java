package org.example.tp3;

public class ProductService {

    private final ProductApiClient productApiClient;

    // Constructor Injection
    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) throws Exception {
        return productApiClient.getProduct(productId);
    }
}

