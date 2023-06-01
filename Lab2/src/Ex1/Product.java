package Ex1;

public class Product {
    private String name;
    private int amount;
    private float price;
    private float value;

    public Product(String name, int amount, float price, float value) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
