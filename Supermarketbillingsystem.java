import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void displayCart() {
        for (CartItem item : items) {
            Product product = item.getProduct();
            System.out.println(product.getName() + " - $" + product.getPrice() + " x " + item.getQuantity());
        }
    }
}

public class Supermarketbillingsystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some sample products
        Product apple = new Product("Apple", 1.0);
        Product banana = new Product("Banana", 0.5);
        Product milk = new Product("Milk", 2.0);

        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("Available Products:");
            System.out.println("1. Apple - $1.0");
            System.out.println("2. Banana - $0.5");
            System.out.println("3. Milk - $2.0");
            System.out.println("4. Checkout");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                break; // Exit the loop and proceed to checkout
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            Product selectedProduct = null;
            switch (choice) {
                case 1:
                    selectedProduct = apple;
                    break;
                case 2:
                    selectedProduct = banana;
                    break;
                case 3:
                    selectedProduct = milk;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid product.");
                    continue;
            }

            CartItem cartItem = new CartItem(selectedProduct, quantity);
            cart.addItem(cartItem);
        }

        System.out.println("\nYour Cart:");
        cart.displayCart();

        double total = cart.calculateTotal();
        System.out.println("Total: $" + total);

        System.out.println("Thank you for shopping!");
    }
}
