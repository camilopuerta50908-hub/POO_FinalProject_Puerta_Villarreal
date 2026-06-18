package domain;
import java.io.Serializable;

/**
 * Represents a concrete video game item with its core attributes and stock tracking.
 */
public class VideoGame implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private Category category;
    private int stock;
    private double price;

    public VideoGame(String id, String title, Category category, int stock, double price) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    /**
     * Formats the video game specifications into a clean readable text line.
     */
    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Genre: [" + category + "] | Stock: " + stock + " | Price: $" + price;
    }
}
