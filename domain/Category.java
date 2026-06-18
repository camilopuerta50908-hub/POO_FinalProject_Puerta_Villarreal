package domain;
import java.io.Serializable;

/**
 * Represents a video game genre or category to classify items in the store.
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /**
     * Returns the string representation of the category name.
     */
    @Override
    public String toString() {
        return name;
    }
}