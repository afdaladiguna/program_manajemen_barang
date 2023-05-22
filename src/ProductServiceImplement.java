
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import config.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductServiceImplement implements ProductService {

    private Connection connection = Database.DBConnection();
    private PreparedStatement statement;

    @Override
    public void addProduct(Product product) {
        try {
            String query = "INSERT INTO product VALUES(NULL, ?, ?, ?, ?, ?)";
            statement = (PreparedStatement) connection.prepareStatement(query);
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getCategory());
            statement.setString(3, String.valueOf(product.getQty()));
            statement.setString(4, String.valueOf(product.getPrice()));
            statement.setString(5, String.valueOf(product.getDateAdded()));

            statement.executeUpdate();

            System.out.println("Product has been added!\n");
            statement.close();

        } catch (SQLException exc) {
            System.out.println("Gagal menambahkan produk " + exc.getMessage());
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            String query = "UPDATE product SET product_name = ?, category = ?, qty = ?, price = ?, date_added = ? WHERE id = ?";
            statement = (PreparedStatement) connection.prepareStatement(query);
            statement.setInt(6, product.getId());
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getCategory());
            statement.setString(3, String.valueOf(product.getQty()));
            statement.setString(4, String.valueOf(product.getPrice()));
            statement.setString(5, String.valueOf(product.getDateAdded()));

            statement.executeUpdate();

            System.out.println("Sukses mengupdate buku dengan id = " + product.getId());
            statement.close();

        } catch (SQLException exc) {
            System.out.println("Gagal mengupdate produk " + exc.getMessage());
        }
    }

    @Override
    public void removeProduct(int id) {
        try {
            String query = "DELETE FROM product WHERE id = ?";
            statement = (PreparedStatement) connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Sukses menghapus buku");

        } catch (SQLException ex) {
            Logger.getLogger(ProductServiceImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Product findBookById(int id) {

        return null;

    }

    @Override
    public List<Product> findProductList() {
        List<Product> products = new ArrayList<>();

        try {
            String query = "SELECT * FROM product";
            statement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Product product = new Product();
                product.setId(result.getInt("id"));
                product.setProductName(result.getString("product_name"));
                product.setCategory(result.getString("category"));
                product.setQty(result.getInt("qty"));
                product.setPrice(result.getInt("price"));
                product.setDateAdded(result.getString("date_added"));

                products.add(product);
            }
            statement.close();
            return products;
        } catch (SQLException exc) {

        }
        return products;
    }

}
