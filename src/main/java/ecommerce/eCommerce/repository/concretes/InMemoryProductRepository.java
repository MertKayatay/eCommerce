package ecommerce.eCommerce.repository.concretes;

import ecommerce.eCommerce.entities.concretes.Product;
import ecommerce.eCommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    List<Product> products;

    public InMemoryProductRepository() {
        products = new ArrayList<>();
        products.add(new Product(1, "Nike Ayakkabı",10, 500.0,"description ayakkabı falan" ));
        products.add(new Product(2, "Adidas Ayakkabı",10, 400.0,"description ayakkabı falan" ));
        products.add(new Product(3, "UnderArmour Ayakkabı",10, 500.0,"description ayakkabı falan" ));
        products.add(new Product(4, "Puma Ayakkabı",10, 400.0,"description ayakkabı falan" ));
    }
    @Override
    public void addProduct(Product product) {
        products.add(product);

    }

    @Override
    public void deleteProduct(int id) {
        for (Product product : products){
            if (product.getId() == id){
                products.remove(product);
            }
        }
    }

    @Override
    public void updateProduct(Product product, int id) {
        for (Product product1 : products){
            if (product1.getId() == id){
                product1.setName(product.getName());
                product1.setQuantity(product.getQuantity());
                product1.setPrice(product.getPrice());
                product1.setDescription(product.getDescription());
            }
        }

    }

    @Override
    public List<Product> getAll() {
        return products;

    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
