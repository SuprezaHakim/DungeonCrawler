# Java Dungeon Crawler Engine


## 🚀 Features
- **Dynamic Map System:** Rooms are linked via a `HashMap` allowing for complex, non-linear map layouts.
- **Inventory System:** Players can collect items using an `ArrayList` based inventory.
- **Parser:** Handles user input commands (go, take, status, quit).
- **Win Condition:** Logic to check for specific game states (e.g., holding a Key while entering the Basement).

## 🛠️ Technical Concepts I used in this Project
- **Object-Oriented Design:** modular classes (`Room`, `Player`, `Game`) to separate concerns.
- **Data Structures:** - `HashMap<String, Room>` for managing map exits efficiently.
  - `ArrayList<String>` for inventory management.
- **Encapsulation:** Private fields with public getters/setters to protect game state.

