package ecommerce.eCommerce.api.controller;

import ecommerce.eCommerce.business.abstracts.ProductService;
import ecommerce.eCommerce.entities.concretes.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getById")
    public Product getById(int id) {
        return productService.getById(id);
    }

    @PostMapping("/add")
    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    @PostMapping("/delete")
    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/update")
    public void updateProduct(Product product, int id) {
        productService.updateProduct(product, id);
    }








}
