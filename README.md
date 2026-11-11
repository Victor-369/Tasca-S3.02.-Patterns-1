# Tasca S3.02 – Patterns 1

Exercises about software design patterns, implemented in Java. Each level focuses on a different pattern and has its own README with the details of the exercise.

## Contents

| Level | Pattern | Description | Details |
|---|---|---|---|
| 1 | Singleton | `Undo` class that keeps a single, shared command history. | [README](src/main/java/com/nivell1/singleton/README.md) |

## Project structure

```
src
├── main/java/com/nivell1/singleton
│   ├── README.md
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

Run every test in the project:

```bash
mvn test
```

Each level's README explains how to run only the tests for that exercise.
