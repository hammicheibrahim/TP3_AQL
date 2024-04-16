package exo3;

import org.example.exo3.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    @Test
    public void testGetProduct_Successful() throws IncompatibleDataFormatException, ApiCallFailureException {
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        Product product = new Product(/* product details */);
        when(mockApiClient.getProduct("productId")).thenReturn(product);
        ProductService productService = new ProductService(mockApiClient);
        Product retrievedProduct = productService.getProduct("productId");
        verify(mockApiClient).getProduct("productId");
    }
    @Test
    public void testGetProduct_IncompatibleDataFormat() throws IncompatibleDataFormatException,ApiCallFailureException  {
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        when(mockApiClient.getProduct("productId")).thenThrow(new IncompatibleDataFormatException());
        ProductService productService = new ProductService(mockApiClient);

        try {
            productService.getProduct("productId");
        } catch (IncompatibleDataFormatException | ApiCallFailureException e) {
            // Do nothing, just catch the exception
        }
        verify(mockApiClient).getProduct("productId");
    }
    @Test
    public void testGetProduct_ApiCallFailure() throws IncompatibleDataFormatException ,ApiCallFailureException{
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        when(mockApiClient.getProduct("productId")).thenThrow(new ApiCallFailureException());
        ProductService productService = new ProductService(mockApiClient);
        try {
            productService.getProduct("productId");
        } catch (IncompatibleDataFormatException | ApiCallFailureException e) {
            // Do nothing, just catch the exception
        }
        verify(mockApiClient).getProduct("productId");
    }

}
