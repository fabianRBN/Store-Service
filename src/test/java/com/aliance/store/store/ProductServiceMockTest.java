package com.aliance.store.store;

import com.aliance.store.store.entity.Category;
import com.aliance.store.store.entity.Product;
import com.aliance.store.store.repository.ProductRepository;
import com.aliance.store.store.service.ProductService;
import com.aliance.store.store.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;
    @BeforeEach
    private void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .name("Computer")
                .category(Category.builder().id(1l).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("124.99"))
                .status("Created")
                .createAt(new Date()).build();

        Mockito.when(productRepository.findById(1l))
                .thenReturn(Optional.of(computer));

        Mockito.when(productRepository.save(computer))
                .thenReturn(computer);
    }
    @Test
    public void whenValidateGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1l);
        Assertions.assertThat(found.getName()).isEqualTo("Computer");
    }
    @Test
    public void whenValidateUpdateStock_ThenReturnNewStock(){
        Product newStock = productService.updateStock(1l,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(18);
    }
}
