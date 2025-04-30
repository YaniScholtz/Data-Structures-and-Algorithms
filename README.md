# Data Structures and Algorithms 

##  Skip List Implementation (Prac1)

This project implements a generic **Skip List** in Java, supporting operations on integers, strings, and characters. It showcases probabilistic level assignment for efficient search, insert, and delete operations.

### Key Features:
- Generic `SkipList<T>` supports any `Comparable` type
- Multi-level node structure for O(log n) average-case operations
- Dynamic insertion and deletion with path tracing
- String representation of list levels for visual debugging
- Works with `Integer`, `String`, and `Character` types

### Core Components:
- **SkipList.java** – Main logic for insertion, deletion, search, and path printing
- **SkipListNode.java** – Multi-level linked node with display formatting
- **Main.java** – Test harness covering:
  - Boundary cases (empty list, missing values)
  - Insertion and deletion
  - Search path output
  - Testing with multiple data types

### Concepts Demonstrated:
- Generics and bounded type parameters (`T extends Comparable<T>`)
- Probabilistic data structures (level promotion logic)
- Linked structures with multiple forward pointers
- Visual debugging through level-by-level display

##   Self-Ordering Lists & Traversal Strategies (Prac2)

This project explores **self-ordering linked lists** using different access strategies, alongside **recursive and iterative traversal** techniques. It forms part of a university-level Data Structures and Algorithms course.

---

###  Concepts Covered

- Self-ordering list strategies:
  - Move-To-Front
  - Transpose
  - Count
  - Natural Order
- Recursive and iterative traversal
- Method overriding with polymorphism
- Deep cloning and reversing lists
- Searching (`contains`, `find`) and indexed access (`get`)

---

###  Files Overview

- `SelfOrderingList.java` – Abstract class for a self-adjusting linked list
- `MoveToFrontList.java` – Reorders by moving accessed element to front
- `TransposeList.java` – Swaps accessed element with previous node
- `CountList.java` – Reorders based on access frequency
- `NaturalOrderList.java` – Maintains a static order regardless of access
- `Traverser.java` – Interface for list traversal
- `RecursiveTraverse.java` – Implements recursive traversal methods
- `IterativeTraverse.java` – Implements iterative traversal methods
- `App.java` / `Main.java` – Runs and compares traversal and reordering methods

---

##  Binary Tree Framework (Prac3)

This project implements a flexible binary tree framework in Java, featuring both **standard** and **mirrored** binary trees. It supports insertion, depth-first traversal, height calculation, parent/child searching, and checking for perfect balance.

---

###  Concepts Demonstrated

- Abstract class implementation (`BinaryTree`)
- Inheritance with `StandardBinaryTree` and `MirroredBinaryTree`
- Recursive traversal and depth management
- Parent finding and value searching
- Tree conversion (mirror ↔ standard)
- Object-oriented programming and generics

---

###  Files Overview

- `BinaryTree.java` – Abstract base with shared structure and method signatures
- `StandardBinaryTree.java` – Inserts left if smaller, right if larger
- `MirroredBinaryTree.java` – Reverses logic: inserts left if larger, right if smaller
- `App.java` – Test driver with hardcoded tree creation, traversal, and method calls

---

