

# Task Tracker CLI

A  command-line interface (CLI) application built in Java for managing daily tasks. 
##  Key Features

* **CRUD Operations:** Create, Read, Update, and Delete tasks efficiently.
* **Unique Identification:** Utilizes `java.util.UUID` for high-entropy, collision-resistant task IDs.
* **State Management:** Uses `HashMap` for  average-time complexity lookups.
* **Status Tracking:** Ability to toggle task states (e.g., Todo, In-Progress, Done).

##  Architecture

The system is decomposed into two primary components to adhere to the **Single Responsibility Principle**:

1. **`Tasktracker.java`**: The main controller handling user input, the application loop, and task logic.
2. **`TaskIdGenerator.java`**: A utility service dedicated to generating cryptographically strong identifiers.

## Installation & Execution

Ensure you have the **Java Development Kit (JDK)** installed.

1. **Clone the repository:**
```bash
git clone https://github.com/suvani-ctrl/Task_tracker_by_fcc
cd task-tracker

```


2. **Compile the source files:**
```bash
javac Tasktracker.java TaskIdGenerator.java

```


3. **Run the application:**
```bash
java Tasktracker

```

## Security
* **Enumeration Prevention:** By using UUIDs instead of auto-incrementing integers, the system prevents simple ID guessing attacks.
* **Input Handling:** Sanitizes user input via `Scanner` to maintain control flow integrity.


---

