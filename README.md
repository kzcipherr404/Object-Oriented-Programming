# Object-Oriented Programming (Java)

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![JUnit 5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=JUnit5&logoColor=white)

Practical coursework, laboratory implementations, and automated unit test suites for the **Object-Oriented Programming (OOP)** university module in Java.

---

## 📖 Curriculum & Weekly Progression

| Week | Core Focus | Concepts Covered | Key Implementations |
| :--- | :--- | :--- | :--- |
| **Week 1** | **OOP Foundations** | Procedural vs. Object-Oriented paradigms, classes, instances, encapsulation basics. | `Hello.java`, `Procedural.java`, `Oop.java` (`Person`) |
| **Week 2** | **BLUEPRINTS, OBJECTS & YOUR FIRST TEST** | Constructors, instance state, Maven project structure, automated testing with JUnit 5. | `BankAccount`, `Student`, `BankAccountTest`, `StudentTest` |
| **Week 3** | **OBJECTS IN MEMORY, NULLS & BUG FIXING** | Stack vs. Heap allocation, primitives vs. references, object aliasing, `null` safety checks, and step-through debugging. | `MemoryDemo`, `AccountManager`, `DebugDemo`, `MemoryDemoTest` |

---

## 📂 Repository Structure

```text
Object-Oriented-Programming/
├── week1/                  # Standalone Java programs exploring OOP vs procedural code
│   ├── Hello.java
│   ├── Oop.java
│   └── Procedural.java
├── week2/                  # Maven project: classes, encapsulation & unit tests
│   ├── pom.xml
│   └── src/
│       ├── main/java/com/oop/      # BankAccount, Student, Main
│       └── test/java/com/oop/      # BankAccountTest, StudentTest
└── week3/                  # Maven project: memory model, references & aliasing
    ├── pom.xml
    └── src/
        ├── main/java/com/oop/      # MemoryDemo, AccountManager, DebugDemo
        └── test/java/com/oop/      # MemoryDemoTest
```

---

## 🛠️ Technology Stack

- **Programming Language:** Java 17+
- **Build & Dependency Management:** Apache Maven
- **Automated Testing:** JUnit 5 (JUnit Jupiter)
- **Development Environment:** Visual Studio Code / IDE with Java Extension Pack

---

## 🚀 Getting Started & Execution

### 1. Clone the Repository
```bash
git clone https://github.com/kzcipherr404/Object-Oriented-Programming.git
cd Object-Oriented-Programming
```

### 2. Running Week 1 (Standalone Java)
```bash
cd week1
javac *.java
java com.oop.Oop
```

### 3. Running Week 2 & Week 3 (Maven & JUnit 5)

Each weekly directory is a standalone Maven module.

#### Run the Automated Test Suites:
```bash
# Test Week 2 (BankAccount & Student tests)
cd week2
mvn test

# Test Week 3 (Memory aliasing & reference tests)
cd ../week3
mvn test
```

#### Compile and Run Main Classes:
```bash
# Compile
mvn clean compile

# Execute a main class via Maven
mvn exec:java -Dexec.mainClass="com.oop.Main"
```

---

## 🧠 Key Insights & Learnings

- **Primitives vs. References:** Primitives hold raw values directly on the stack; reference types hold memory addresses pointing to objects allocated on the heap.
- **Aliasing:** Assigning one object reference to another copies the memory address, meaning both variables point to and modify the same underlying object state.
- **Null Safety:** Handling `null` references defensively with conditional checks prevents `NullPointerException` crashes at runtime.
- **Test-Driven Design:** Leveraging JUnit 5 assertions (`assertEquals`, `assertNotNull`, etc.) to verify object behavior and state mutations deterministically.

---

## 👤 Author

- **GitHub:** [@kzcipherr404](https://github.com/kzcipherr404)

---

## 📜 Academic Integrity Note

This repository contains educational coursework and laboratory implementations. Please adhere to your university's academic integrity policies regarding sharing and referencing code.
