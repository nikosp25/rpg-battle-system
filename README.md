# Java Console RPG

A simple turn-based combat game played entirely in the terminal.

## How it works
The game runs through a series of 5 encounters. The player selects a character class and fights through waves of enemies, ending in a boss fight against a Dragon.

## Project Structure
* **`Main.java`**: Handles the primary game loop and initialization.
* **`ui` package**: Contains classes for narration, menus, and input validation.
* **`entities` package**: Contains the base Entity class and specialized subclasses (Mage, Knight, etc.).
* **`BattleManager.java`**: Manages the turn-based logic and win/loss states.

## Key Features
* **Turn-based logic**: Heroes and enemies take turns until one side is defeated.
* **Input Validation**: Prevents crashes if a user enters a string instead of a number.
* **Polymorphism**: Uses method overriding so different classes have unique attacks.

## Current Status
The core game loop is functional. I'm currently working on adding a "Play Again" feature to the main menu.