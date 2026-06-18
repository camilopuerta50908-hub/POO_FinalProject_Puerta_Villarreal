package data;

import domain.VideoGame;
import java.io.*;
import java.util.ArrayList;

/**
 * Utility class responsible for file persistence, saving and loading data locally.
 */
public class DataManager {

    /**
     * Serializes the current video game list and stores it in a binary data file.
     */
    public static void saveInventory(ArrayList<VideoGame> data, String filePath) {
        try {
            FileOutputStream fileStream = new FileOutputStream(filePath);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(data);
            objectStream.close();
            fileStream.close();
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    /**
     * Deserializes the video game list from a local file. Returns an empty array if file does not exist.
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<VideoGame> loadInventory(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) return new ArrayList<VideoGame>();
        try {
            FileInputStream fileStream = new FileInputStream(filePath);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            ArrayList<VideoGame> data = (ArrayList<VideoGame>) objectStream.readObject();
            objectStream.close();
            fileStream.close();
            return data;
        } catch (Exception e) {
            return new ArrayList<VideoGame>();
        }
    }

    /**
     * Saves financial income records into a standard primitive data stream file.
     */
    public static void saveEarnings(double earnings, String filePath) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath));
            out.writeDouble(earnings);
            out.close();
        } catch (IOException e) {
            System.err.println("Error saving earnings: " + e.getMessage());
        }
    }

    /**
     * Loads total financial accumulated income from the disk. Returns 0.0 if not found.
     */
    public static double loadEarnings(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) return 0.0;
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(filePath));
            double earnings = in.readDouble();
            in.close();
            return earnings;
        } catch (Exception e) {
            return 0.0;
        }
    }
}