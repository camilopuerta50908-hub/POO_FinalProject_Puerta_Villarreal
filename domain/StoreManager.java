package domain;

import data.DataManager;
import java.util.ArrayList;

/**
 * Main business controller managing active inventory operations, sales execution, and storage triggers.
 */
public class StoreManager {
    private ArrayList<VideoGame> games;
    private ArrayList<Category> categories;
    private double totalEarnings;
    
    private static final String FILE_INV = "games.dat";
    private static final String FILE_EARN = "earnings.dat";

    /**
     * Instantiates the manager, registers system default categories, and fetches data from storage.
     */
    public StoreManager() {
        this.games = DataManager.loadInventory(FILE_INV);
        this.totalEarnings = DataManager.loadEarnings(FILE_EARN);
        this.categories = new ArrayList<>();
        
        // Default system categories initialization
        categories.add(new Category("Action"));
        categories.add(new Category("RPG"));
        categories.add(new Category("Sports"));
        categories.add(new Category("Shooter"));
    }

    /**
     * Appends a new video game entity to the tracking list and synchronizes state to disk.
     */
    public void addVideoGame(VideoGame game) {
        games.add(game);
        sync();
    }

    /**
     * Exposes the complete list of video games currently available.
     */
    public ArrayList<VideoGame> getAllGames() {
        return games;
    }

    /**
     * Exposes default classifications configured into the system.
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    /**
     * Sequentially scans the collection to isolate a single game matching the targeted unique ID.
     */
    public VideoGame findGameById(String id) {
        for (VideoGame g : games) {
            if (g.getId().equalsIgnoreCase(id)) return g;
        }
        return null;
    }

    /**
     * Validates and updates game stock levels while adding item values to cumulative business income streams.
     */
    public boolean registerSale(String id, int quantity) {
        VideoGame game = findGameById(id);
        if (game != null && game.getStock() >= quantity) {
            game.setStock(game.getStock() - quantity);
            totalEarnings += (game.getPrice() * quantity);
            sync();
            return true;
        }
        return false;
    }

    /**
     * Retrieves total stored sales earnings records.
     */
    public double getTotalEarnings() {
        return totalEarnings;
    }

    /**
     * Internal routine to commit all structural application states to their local data storage files.
     */
    private void sync() {
        DataManager.saveInventory(games, FILE_INV);
        DataManager.saveEarnings(totalEarnings, FILE_EARN);
    }
}