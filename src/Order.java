import java.util.Random;

public class Order {
    private Buyer buyer;
    private Product product;
    private int quantity;
    private Discount discount;
    private float cost;

    public Order(Buyer buyer, Product product, int quantity) {
        this.buyer = buyer;
        this.product = product;
        this.quantity = quantity;
        setCost();
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setCost() {
        Random random = new Random();
        this.discount = Discount.values()[random.nextInt(4)];
        cost = product.getPrice() * (discount.i/100);
        System.out.println(discount);
        System.out.println(cost);
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }


}
