# OOP Lab 4: Scribe Answers & Lab Notes
**Topic:** Encapsulation, Access Control & Input Validation  
**Course:** Object-Oriented Programming (Java)  
**Lecturer:** Jacob Chikwanda  

---

## Part 1 — The Bug, Live (Pages 2–3)

### Code Run
```java
BankAccount jacobsAccount = new BankAccount();
jacobsAccount.deposit(500);
jacobsAccount.balance = -9999;
System.out.println(jacobsAccount.balance);
```

- **Prediction:** `-9999`
- **Actual Output:** `-9999`

### Scribe: In Your Own Words
> **Prompt:** *Why is a public field on `balance` a real security problem, not just an untidy one?*

**Answer:**  
A public field completely bypasses the object's encapsulation and internal business rules. Any external code or malicious caller can directly mutate the account's state without consent, validation, checks (e.g. overdraft limits), or audit logging. It allows the object to enter an illegal or impossible state (such as a negative balance) silently.

---

## Part 2 — One Word Closes the Door (Page 4)

- **Action:** Changed field to `private double balance;`.
- **Result in `Main.java`:**
  ```text
  error: balance has private access in BankAccount
  ```
- **Takeaway:** Information hiding ensures internal data is unreachable from the outside. `deposit()` still works because it is a member of `BankAccount`, while outside code must respect the public interface.

---

## Part 3 — Proving the Four Access Levels (Pages 5–7)

### Bug Hunter Predictions
1. **Same Package (`com.oop`):**  
   Accessing `p.fieldPrivate` causes a compiler error. `fieldDefault`, `fieldProtected`, and `fieldPublic` all compile and run normally.
2. **Different Package (`com`):**  
   Accessing `p.fieldDefault` and `p.fieldProtected` both fail to compile (`not visible` / `has protected access`). Only `p.fieldPublic` can be accessed across packages.

### Scribe: Access Modifier Matrix

| Modifier | Same Class | Same Package | Different Package |
| :--- | :---: | :---: | :---: |
| **`private`** | ✓ | ✗ | ✗ |
| **`(nothing)` default** | ✓ | ✓ | ✗ |
| **`protected`** | ✓ | ✓ | ✗ *(accessible to subclasses only)* |
| **`public`** | ✓ | ✓ | ✓ |

### Private Helper Method
- Calling `jacobsAccount.isValidAmount(5)` from `Main.java` fails to compile because it is an internal implementation detail, not part of the class's public contract.

---

## Part 4 — Getters, and the Setter Trap (Pages 8–9)

### Bug Hunter: Stop and Check
> **Prompt:** *Call `jacobsAccount.setBalance(-9999);` from `Main`. What just happened, compared to Part 1?*

**Answer:**  
Nothing was gained. Adding a raw `setBalance(double amount)` simply reopens the exact vulnerability that `private` was introduced to fix. It is functionally identical to a public field, just wrapped in extra syntax.

**Rule of Thumb:**  
Write a getter when outside callers legitimately need to read the value. Avoid generic setters on core business state; only allow mutations through domain operations with explicit validation (e.g. `deposit()` and `withdraw()`).

---

## Part 5 — Constructors and Overloading (Pages 10–12)

### Predict & Observe
> **Prompt:** *What happens to `new BankAccount()` after writing an explicit 2-argument constructor?*

**Output:**
```text
error: constructor BankAccount cannot be applied to given types;
  required: String, double
  found: no arguments
```
**Reason:** The free default no-argument constructor provided by Java is retracted the moment any explicit constructor is defined.

### Scribe: Constructor Overload Outputs
Using constructor delegation (`this(accountHolder, 0);`):

```java
BankAccount b1 = new BankAccount("Jacob", 1000000);
BankAccount b2 = new BankAccount("Jane");
BankAccount b3 = new BankAccount();

b1.getAccountDetails();
b2.getAccountDetails();
b3.getAccountDetails();
```

- **`b1` Output:** `Name: Jacob, Balance: 1000000.0`
- **`b2` Output:** `Name: Jane, Balance: 0.0`
- **`b3` Output:** `Name: null, Balance: 0.0`

---

## Part 6 — Refuse Loudly: Validation with Exceptions (Pages 13–14)

### Silent Guard vs Loud Refusal
- **Silent Guard (`if (isValidAmount) { ... }`):** Ignores invalid inputs silently, masking bugs and misleading callers into assuming the transaction was processed.
- **Loud Refusal (`throw new IllegalArgumentException(...)`):** Immediately raises an error with descriptive context (`"Deposit must be positive, got: -500.0"`), forcing caller code to acknowledge and handle the failure.

### Bug Hunter: `try / catch / finally` Prediction
> **Prompt:** *Run it once with -100, once with 100. Which line runs both times, no matter what?*

**Answer:**  
The `finally` block:
```java
System.out.println("Transaction attempt logged.");
```
runs on **every** execution, regardless of whether an exception was thrown or caught.

---

## Part 7 — Test It Through the Public Door (Pages 15–16)

### Testing Principles
- Unit tests should test behavior through the public interface (`deposit()`, `getBalance()`), never by breaking encapsulation or making fields public just to assert state.
- `assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));` verifies that invalid inputs fail loudly and leave balance unchanged.

---

## Part 8 — AI Code Review & Verification (Pages 17–18)

### Scribe: Two Findings from AI Review
1. **The Setter Trap (Reflexive Mutators):** AI models frequently generate standard boilerplate getters and setters for all fields (`setBalance(...)`), inadvertently exposing private state and bypassing business invariants.
2. **Missing Constructor Validation:** AI tools often implement checks inside mutator methods like `deposit()`, but overlook parameter validation in constructors, permitting an object to be instantiated directly in an invalid state (e.g. negative initial balance).
