package ecommerce.eCommerce.business.abstracts;

import ecommerce.eCommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    boolean isValid(Product product);

    public void addProduct(Product product);
    public void deleteProduct(int id);
    public void updateProduct(Product product, int id);

    List<Product> getAll();

    Product getById(int id);

}
