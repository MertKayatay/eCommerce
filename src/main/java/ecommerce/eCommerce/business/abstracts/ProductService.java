package ecommerce.eCommerce.business.abstracts;

import ecommerce.eCommerce.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    public Product add(Product product);
    public Product update(Product product, int id);
    public void delete(int id);



}
