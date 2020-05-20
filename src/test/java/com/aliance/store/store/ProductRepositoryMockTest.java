package com.aliance.store.store;

import com.aliance.store.store.entity.Category;
import com.aliance.store.store.entity.Product;
import com.aliance.store.store.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {
    @Autowired
    private ProductRepository productRepository;


    // Programacion de prueba unitaria
    @Test
    public void whenFinByCategory_thenReturnListProduct(){

        Product product01 = Product.builder()
                .name("Computer")
                .category(Category.builder().id(1l).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("124.99"))
                .status("Created")
                .createAt(new Date()).build();
        productRepository.save(product01);

        List<Product> listProductos = productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(listProductos.size()).isEqualTo(3);

    }
}
