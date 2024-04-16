package org.example.exo3;

public interface ProductApiClient {
    Product getProduct(String productId) throws ApiCallFailureException, IncompatibleDataFormatException;
}
