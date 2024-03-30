package tn.esprit.devops_project.entities;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.Iservices.IProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class ProductServiceImplTest {



    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductService productService;

    @Test
    public void testAddProduct() {
        // Créer un produit à ajouter
        Product product = new Product();
        product.setTitle("Test Product");
        product.setPrice(10.0f);
        product.setQuantity(5);
        product.setCategory(ProductCategory.ELECTRONICS);

        // Ajouter le produit
        Product addedProduct = productService.addProduct(product, 1L);

        // Vérifier si le produit est ajouté avec succès
        assertEquals("Test Product", addedProduct.getTitle());
    }

    @Test
    public void retrieveAllProducts(){
        List<Product> products = productService.retreiveAllProduct();
        assertNotNull(products);
    }

    @Test
    public void retrieveProduct(){
        Product savedProduct = productService.retrieveProduct(1L);
        assertNotNull(savedProduct);
        assertEquals(1L,1L);
    }



}