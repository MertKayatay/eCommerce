package ecommerce.eCommerce.business.concretes;

import ecommerce.eCommerce.business.abstracts.ProductService;
import ecommerce.eCommerce.entities.concretes.Product;
import ecommerce.eCommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public boolean isValid(Product product) {
        if (product.getPrice() <= 0 || product.getQuantity() <= 0
        || (product.getDescription().length() < 10 || product.getDescription().length() > 50)) {
            return false;
        }else {
            return true;
        }

    }


    @Override
    public void addProduct(Product product) {
        if(!isValid(product)){
            throw new RuntimeException("Cannot added");
        }else {
            productRepository.addProduct(product);
            System.out.println("Product Added");

        }
    }

    @Override
    public void deleteProduct(int id) {
        if(productRepository.getAll().size() == 0){
            throw new RuntimeException("there are no products");
        } else if (productRepository.getById(id) == null) {
            throw new RuntimeException("there is no product");
        }else {
            productRepository.deleteProduct(id);
            System.out.println("Product Deleted");
        }
    }


    @Override
    public void updateProduct(Product product, int id){
        if(productRepository.getAll().size() == 0){
            throw new RuntimeException("there are no products");
        } else if (productRepository.getById(id) == null) {
            throw new RuntimeException("there is no product");
        } else if(!isValid(product)){
            throw new RuntimeException("Cannot updated");
    }else {
            productRepository.updateProduct(product, id);
            System.out.println("Product Updated");
        }
    }

    @Override
    public List<Product> getAll() {
        if (productRepository.getAll().size() == 0) {
            throw new RuntimeException("empty");
        }
        return productRepository.getAll();
    }

    @Override
    public Product getById(int id) {

        return productRepository.getById(id);
    }
}
