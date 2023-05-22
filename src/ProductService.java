
import java.util.List;

public interface ProductService {
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void removeProduct(int id);
    public List<Product> findProductList();
    public Product findBookById(int id);
}
