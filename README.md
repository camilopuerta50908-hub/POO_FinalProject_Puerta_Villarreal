# POO_FinalProject_Puerta_Villarreal
# Video Game Store Inventory and Sales System

## Group Members
* **Camilo Andrés Puerta Mejía** - Code: 50908
* **Juan David Villarreal Nuñez** - Code: 63753

---

## Project Description
This is a Java console application designed for video game retail stores to manage their product inventory and process daily transactions. The system provides employees with an interactive interface to perform complete CRUD operations on video games, classify them by specific categories (genres), and record sales in real time. 

Every time a transaction is made, the system automatically updates the product stock and adds the transaction amount to the total store earnings. To ensure data persistence across multiple sessions, the application reads and writes all records into local binary files (`games.dat` and `earnings.dat`), preventing any data loss when the program terminates.

---

## How to Run the Application


### Execution Steps
1. Open your terminal and navigate to the project's root directory:
   ```bash
   cd POO_FinalProject_VideoGameStore
javac -d bin data/*.java domain/*.java ui/*.java
java -cp bin ui.Main

Input / Output Example
Example 1: Registering a New Video Game
=============================================
       VIDEO GAME STORE SYSTEM V1.0          
=============================================

--- MAIN MENU ---
1. Register New Video Game
2. Check Inventory
3. Register a Sale
4. View Total Earnings
5. Generate Basic Report
6. Exit
Choose an option: 1

--- New Video Game ---
Enter unique Game ID: G01
Enter Title: Elden Ring
Available Genres:
0. Action
1. RPG
2. Sports
3. Shooter
Select Genre Number: 1
Enter Initial Stock: 10
Enter Price ($): 59.99
Game registered successfully.

Example 2: Processing a Sale and Checking Revenue
--- MAIN MENU ---
...
Choose an option: 3

--- Process Sale ---
Enter Game ID to sell: G01
Enter Quantity: 2
Sale registered! Stock updated.

Choose an option: 4

Total Income from Sales: $119.98