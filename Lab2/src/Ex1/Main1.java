package Ex1;

public class Main1 {
    public static void main(String[] args) {
        Product p1 = new Product("Keyboard", 15, 49.99F, 15 * 49.99F);
        Product p2 = new Product("Mouse", 12, 19.99F, 12 * 19.99F);
        Product p3 = new Product("Mouse pad", 48, 5, 58 * 5);
        Product p4 = new Product("Headset", 0, 32.5F, 0);
        Product p5 = new Product("Monitor", 2, 143.8F, 2 * 143.8F);
        Product p6 = new Product("Laptop", 0, 1000, 0);
        Product p7 = new Product("Lamp", 0, 12.5F, 0);

        Product[] products = new Product[]{p1, p2, p3, p4, p5, p6, p7};

        MenageProducts productsData = new MenageProducts(products);

        //Display products
        System.out.println("Array of products:");
        productsData.displayProducts();

        //Change prices
        System.out.println("Change operation logs:");
        productsData.changeProductPrice("Mouse", 15);
        productsData.changeProductPrice("Mouse pad", 7);
        productsData.changeProductPrice("Headset", 40.99F);

        //Display products to see results
        System.out.printf("%n%s%n", "Array of products:");
        productsData.displayProducts();

        //Display products cheaper then X
        System.out.println("Array of products cheaper than 40.99$:");
        productsData.displayProductsCheaperThan(40.99F);
        System.out.println("Array of products cheaper than 5$:");
        productsData.displayProductsCheaperThan(5);
        System.out.println("Array of products cheaper than 2000$:");
        productsData.displayProductsCheaperThan(2000);

        //Get and display array of out of stock products
        Product[] outOfStock = productsData.getProductsOutOfStock();
        MenageProducts helper = new MenageProducts(outOfStock); //Use 'MenageProducts' class to display products and check results
        System.out.println("Array of out of stock products:");
        helper.displayProducts();
    }
}
