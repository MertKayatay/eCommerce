package ecommerce.eCommerce.business.concretes;

import ecommerce.eCommerce.business.abstracts.ProductService;
import ecommerce.eCommerce.entities.Product;
import ecommerce.eCommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;



    private void checkIfProductExists(int id) {
        if (!productRepository.existsById(id)) throw new IllegalArgumentException("There is no product");
    }


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        checkIfProductExists(id);
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, int id) {
        checkIfProductExists(id);
        return productRepository.save(product);

    }

    @Override
    public void delete(int id) {
        checkIfProductExists(id);
        productRepository.deleteById(id);
    }
}
