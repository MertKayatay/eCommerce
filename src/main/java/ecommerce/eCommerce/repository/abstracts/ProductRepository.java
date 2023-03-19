package ecommerce.eCommerce.repository.abstracts;

import ecommerce.eCommerce.entities.concretes.Product;

import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product, int id);
    List<Product> getAll();
    Product getById(int id);

}
