package ecommerce.eCommerce.api.controller;

import ecommerce.eCommerce.business.abstracts.ProductService;
import ecommerce.eCommerce.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {

        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {

        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) {

        productService.add(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody  Product product,@PathVariable int id) {

        productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct( @PathVariable int id) {

        productService.delete(id);
    }










}
