# Java Dungeon Crawler Engine

A text-based interactive fiction engine built in Java. This project demonstrates core Object-Oriented Programming (OOP) principles, including encapsulation, class relationships, and dynamic data structures.

## 🚀 Features
- **Dynamic Map System:** Rooms are linked via a `HashMap` allowing for complex, non-linear map layouts.
- **Inventory System:** Players can collect items using an `ArrayList` based inventory.
- **Parser:** Handles user input commands (go, take, status, quit).
- **Win Condition:** Logic to check for specific game states (e.g., holding a Key while entering the Basement).

## 🛠️ Technical Concepts
- **Object-Oriented Design:** modular classes (`Room`, `Player`, `Game`) to separate concerns.
- **Data Structures:** - `HashMap<String, Room>` for managing map exits efficiently.
  - `ArrayList<String>` for scalable inventory management.
- **Encapsulation:** Private fields with public getters/setters to protect game state.

## 🎮 How to Run
1. Ensure you have Java installed.
2. Clone this repository or download the files.
3. Open a terminal/command prompt in the project folder.
4. Compile the source code:
   ```bash
   javac *.java