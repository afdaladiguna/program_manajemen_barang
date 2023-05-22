

public class Product {
    private int id;
    private String productName;
    private String category;
    private int qty;
    private int price;
    private String dateAdded;

    public Product(int id, String productName, String category, int qty, int price, String dateAdded) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.qty = qty;
        this.price = price;
        this.dateAdded = dateAdded;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQty() {
        return qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
