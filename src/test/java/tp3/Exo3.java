package tp3;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.tp3.Product;
import org.example.tp3.ProductApiClient;
import org.example.tp3.ProductService;
import org.junit.jupiter.api.Test;

class Exo3 {

    @Test
    void testGetProduct_SuccessfulRetrieval() throws Exception {
        // Arrange
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(mockApiClient);

        Product expectedProduct = new Product("123", "Smartphone");

        when(mockApiClient.getProduct("123")).thenReturn(expectedProduct);

        // Act
        Product result = productService.getProduct("123");

        // Assert
        assertNotNull(result);
        assertEquals("123", result.getId());
        assertEquals("Smartphone", result.getName());

        // Verify
        verify(mockApiClient, times(1)).getProduct("123");
    }

    @Test
    void testGetProduct_FormatError() throws Exception {
        // Arrange
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(mockApiClient);

        when(mockApiClient.getProduct("bad_format"))
                .thenThrow(new IllegalArgumentException("Invalid product format"));

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productService.getProduct("bad_format");
        });

        assertEquals("Invalid product format", exception.getMessage());

        // Verify
        verify(mockApiClient, times(1)).getProduct("bad_format");
    }

    @Test
    void testGetProduct_ApiFailure() throws Exception {
        // Arrange
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(mockApiClient);

        when(mockApiClient.getProduct("server_down"))
                .thenThrow(new RuntimeException("API not reachable"));

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.getProduct("server_down");
        });

        assertEquals("API not reachable", exception.getMessage());

        // Verify
        verify(mockApiClient, times(1)).getProduct("server_down");
    }
}

