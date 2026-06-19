package ui;

import domain.StoreManager;
import domain.Category;
import domain.VideoGame;

/**
 * Main execution entry point containing the system interactive workflow engine.
 */
public class Main {
    private static StoreManager store = new StoreManager();

    public static void main(String[] args) {
        UI io = new UIConsole();
        boolean running = true;

        io.showText("=============================================");
        io.showText("       VIDEO GAME STORE SYSTEM V1.0          ");
        io.showText("=============================================");

        while (running) {
            io.showText("\n--- MAIN MENU ---");
            io.showText("1. Register New Video Game");
            io.showText("2. Check Inventory");
            io.showText("3. Register a Sale");
            io.showText("4. View Total Earnings");
            io.showText("5. Generate Basic Report");
            io.showText("6. Exit");

            String option = io.inputText("Choose an option:");

            if (option.equals("1")) {
                registerGame(io);
            } else if (option.equals("2")) {
                showInventory(io);
            } else if (option.equals("3")) {
                makeSale(io);
            } else if (option.equals("4")) {
                io.showText("\nTotal Income from Sales: $" + store.getTotalEarnings());
            } else if (option.equals("5")) {
                generateReport(io);
            } else if (option.equals("6")) {
                running = false;
                io.showText("Closing system. All data backed up.");
            } else {
                io.showText("Invalid option.");
            }
        }
    }

    /**
     * Prompts the operator for metadata inputs to assemble and add a new Game instance.
     */
    private static void registerGame(UI io) {
        try {
            io.showText("\n--- New Video Game ---");
            String id = io.inputText("Enter unique Game ID:");
            if (store.findGameById(id) != null) {
                io.showText("Error: Game ID already exists.");
                return;
            }

            String title = io.inputText("Enter Title:");
            
            io.showText("Available Genres:");
            for (int i = 0; i < store.getCategories().size(); i++) {
                io.showText(i + ". " + store.getCategories().get(i));
            }
            int catIdx = io.inputInt("Select Genre Number:");
            Category selectedCategory = store.getCategories().get(catIdx);

            int stock = io.inputInt("Enter Initial Stock:");
            double price = io.inputDouble("Enter Price ($):");

            VideoGame newGame = new VideoGame(id, title, selectedCategory, stock, price);
            store.addVideoGame(newGame);
            io.showText("Game registered successfully.");
        } catch (Exception e) {
            io.showText("Input Error: Invalid data format.");
        }
    }

    /**
     * Lists all products inside the database storage, printing their status onto screen.
     */
    private static void showInventory(UI io) {
        io.showText("\n--- Store Inventory ---");
        if (store.getAllGames().isEmpty()) {
            io.showText("No games in stock.");
            return;
        }
        for (VideoGame g : store.getAllGames()) {
            io.showText(g);
        }
    }

    /**
     * Captures specific transaction metrics from users and forwards them to complete a sale deduction.
     */
    private static void makeSale(UI io) {
        try {
            io.showText("\n--- Process Sale ---");
            String id = io.inputText("Enter Game ID to sell:");
            int qty = io.inputInt("Enter Quantity:");

            if (store.registerSale(id, qty)) {
                io.showText("Sale registered! Stock updated.");
            } else {
                io.showText("Sale failed. Check ID or stock availability.");
            }
        } catch (Exception e) {
            io.showText("Error: Quantity must be a number.");
        }
    }

    /**
     * Computes totals across items and outputs high-level store diagnostic reports.
     */
    private static void generateReport(UI io) {
        io.showText("\n=============================================");
        io.showText("            BASIC STORE REPORT               ");
        io.showText("=============================================");
        int totalTitles = store.getAllGames().size();
        int totalItems = 0;
        for (VideoGame g : store.getAllGames()) {
            totalItems += g.getStock();
        }
        io.showText("Total Unique Titles: " + totalTitles);
        io.showText("Total Physical Units in Store: " + totalItems);
        io.showText("Current Financial Revenue: $" + store.getTotalEarnings());
        io.showText("=============================================");
    }
}