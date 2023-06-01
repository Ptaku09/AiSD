package Ex1;

import java.util.Objects;

public class MenageProducts {
    private Product[] products;

    public MenageProducts(Product[] products) {
        this.products = products;
    }

    public void displayProducts() {
        ArrayIterator<Product> iterator = new ArrayIterator<>(products);

        System.out.printf("%-20s %7s %12s %14s%n", "Name", "Amount", "Price", "Value");

        while (iterator.hasNext()) {
            Product current = iterator.next();

            System.out.printf("%-20s %7d %12.2f %14.2f%n", current.getName(), current.getAmount(), current.getPrice(), current.getValue());
        }

        System.out.println();
    }

    public void changeProductPrice(String productName, float price) {
        ArrayIterator<Product> iterator = new ArrayIterator<>(products);

        while (iterator.hasNext()) {
            Product current = iterator.next();

            if (Objects.equals(current.getName(), productName)) {
                current.setPrice(price);
                current.setValue(current.getAmount() * price);

                System.out.print("Price of " + current.getName() + " is set to: ");
                System.out.printf("%.2f%n", price);
                break;
            }
        }
    }

    public void displayProductsCheaperThan(float price) {
        ArrayIterator<Product> iterator = new ArrayIterator<>(products);
        Predicate<Product> predicate = arg -> arg.getPrice() < price;
        FilteredIterator<Product> filteredIterator = new FilteredIterator<>(iterator, predicate);

        System.out.printf("%-20s %7s %12s %14s%n", "Name", "Amount", "Price", "Value");

        while (filteredIterator.hasNext()) {
            Product current = filteredIterator.next();

            System.out.printf("%-20s %7d %12.2f %14.2f%n", current.getName(), current.getAmount(), current.getPrice(), current.getValue());
        }

        System.out.println();
    }

    public Product[] getProductsOutOfStock() {
        ArrayIterator<Product> iterator = new ArrayIterator<>(products);
        Predicate<Product> predicate = arg -> arg.getAmount() == 0;
        FilteredIterator<Product> filteredIterator = new FilteredIterator<>(iterator, predicate);

        Product[] outOfStock;
        Product[] outOfStockHelper = new Product[products.length];
        int amount = 0;

        while (filteredIterator.hasNext()) {
            outOfStockHelper[amount] = filteredIterator.next();
            amount++;
        }

        outOfStock = new Product[amount];

        for (int i = 0; i < amount; i++) {
            outOfStock[i] = outOfStockHelper[i];
        }

        return outOfStock;
    }
}
