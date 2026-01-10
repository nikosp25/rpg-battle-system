# Java Console RPG

A turn-based combat game played entirely in the terminal. I created this project to practice Object-Oriented Programming (OOP) concepts and Java syntax.

## ✅ Project Status
**Completed.** This project was created for me to practice certain java concepts and is done. 

## 📖 Overview
The game simulates a dungeon crawler where the player leads a party of 3 heroes. The game runs through a series of random encounters, ending in a guaranteed boss fight against a Dragon at the 5th encounter.

## 💻 Concepts Applied
This project was built to demonstrate specific coding concepts:
* **Inheritance & Polymorphism**: Created a base `Entity` class with `Knight`, `Mage`, and `Rogue` subclasses that override attack methods and `toString` for stats.
* **Game Loop Logic**: Implemented a `do-while` loop in `Main.java` to handle game states and allow the user to replay without restarting the program.
* **Input Validation**: Used `try-catch` blocks and scanner checks to prevent the application from crashing if the user enters invalid text.
* **Encapsulation**: Separated the combat logic into a `BattleManager` class to keep the `Main` class clean.

## 📂 Project Structure
* **`Main.java`**: The entry point. Handles the "Play Again" loop and character creation.
* **`BattleManager.java`**: The engine that runs the turn-based logic, enemy spawning, and win/loss conditions.
* **`entities/`**: Contains the character classes (Heroes and Monsters).
* **`ui/`**: Handles narration and text formatting.



***
*Created as a personal project for learning Java.*