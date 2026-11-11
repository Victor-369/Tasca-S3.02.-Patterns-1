# Tasca S3.02 – Patterns 1

## Level 1 – Singleton pattern

### About the exercise

The aim of this exercise is to implement the **Singleton** design pattern through an `Undo` class that mimics the basic behaviour of an undo command.

The Singleton pattern guarantees that a class has only **one instance** and provides a **global access point** to it. In this case, it means the whole application shares the same command history.

### The `Undo` class

The class:

- Has a **private constructor**, so it cannot be instantiated from outside.
- Creates its single instance when the class is loaded and exposes it through the static method `getInstance()`.
- Stores the commands in a `List<String>`.

It provides the following methods:

| Method | Description |
|---|---|
| `void addCommand(String command)` | Adds a command to the history. Null or blank commands are rejected with an `IllegalArgumentException`. |
| `String undoCommand()` | Returns and removes the last command. If the history is empty, it returns an empty string. |
| `void showHistory()` | Prints every stored command in order, similar to `history` in Linux. |

### Unit tests

The implementation is verified with JUnit Jupiter and AssertJ in `UndoTest`:

- `getInstance()` always returns the same instance.
- `addCommand()` adds the command to the end of the history.
- `undoCommand()` returns and removes the last command, and returns an empty string when there is nothing left.
- `addCommand()` rejects `null`, empty and blank commands.
- `showHistory()` prints every command in the right order. The console output is captured during the test to check what is printed.

As the instance is shared, the history is emptied before each test and filled with the same set of sample data, so the tests do not depend on each other or on the order in which they run.

## Project structure

```
src
├── main/java/com/nivell1/singleton
│   └── Undo.java
└── test/java/com/nivell1/singleton
    └── UndoTest.java
```

## Technologies

- Java 25
- Maven
- JUnit Jupiter
- AssertJ

## How to run the tests

```bash
mvn test
```
