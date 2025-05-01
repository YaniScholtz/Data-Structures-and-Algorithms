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

##  Binary Tree Practical (Prac3)


This practical implements a binary tree framework in Java with support for both **standard** and **mirrored** insertion logic. It includes functionality to insert values, traverse the tree, check balance, and convert between tree types. The tree operates using recursion and generic types.

---

###  Concepts Covered

- Abstract classes and inheritance
- Generic data structures (`BinaryTree<T>`)
- Recursive traversal and search
- Tree height, leaf count, and balance checking
- Mirrored vs standard insertion logic
- Tree conversion methods

---

###  Files Overview

- `BinaryTree.java` – Abstract base class with shared tree logic
- `StandardBinaryTree.java` – Inserts smaller values to the left
- `MirroredBinaryTree.java` – Inserts larger values to the left
- `App.java` – Test class for inserting, traversing, and converting trees

## min-D Heap Implementation (Prac4)


This practical implements a generic **min-D heap** in Java — a generalization of the binary heap where each node can have _d_ children. It supports insertion, removal, dynamic changes to _d_, and root-to-node path tracing. The heap maintains the min-heap property throughout.

---

###  Concepts Covered

- Heap data structures and min-heap property
- Generalized _d_-ary heap with dynamic arity changes
- Generics and `Comparable<T>` interface
- Recursive and iterative heap operations
- Tree traversal (path to root), min/max subtrees
- Custom pretty-print and array visualization

---

###  Files Overview

- `minDHeap.java` – Core heap logic with insert, remove, change-arity, min/max, and path functions
- `Main.java` – Test driver demonstrating:
  - Insertion and printing
  - Tree rebalancing
  - Subtree min/max retrieval
  - Node path tracing

##  B-Tree Implementation (Prac5)

This practical implements a generic **B-Tree** data structure in Java, used for efficient data storage and retrieval. The B-Tree maintains balance through dynamic node splitting and supports multiple keys per node. It includes insertion, searching, node counting, and in-order traversal.

---

### Concepts Covered

- B-Trees and balanced multi-way search trees
- Node splitting and key promotion
- Generic programming with `Comparable<T>`
- Recursive insertion and traversal
- Object-oriented structure with parent and child references

---

###  Files Overview

- `BTree.java` – Core B-Tree logic including insert, find, node/key counting, and traversal
- `Node.java` – Internal node representation with key and child management
- `App.java` – Test class demonstrating insertions, search operations, and structural checks

##  Graph Framework (Prac6)


This practical implements a generic graph data structure in Java using an adjacency matrix. The framework supports vertex and edge insertion/removal, depth-first and breadth-first traversal, shortest path calculation (Dijkstra and Floyd-Warshall), cycle detection, and strongly connected components. 


### Concepts Covered

- Graph representation using adjacency matrices
- File-based graph loading
- Depth-first and breadth-first traversal
- Shortest path algorithms (Dijkstra, Floyd-Warshall)
- Cycle detection with DFS
- Graph modification: add/remove edges and vertices
- Object-oriented design and testing

---

###  Files Overview

- `Graph.java` – Core graph class implementing traversal, pathfinding, and modification methods
- `Main.java` – Driver class to test graph creation, traversal, shortest paths, and cycle checks.

## Advanced Graph Implementation (Prac7)

This practical implements an advanced graph data structure using **object-oriented design**. It supports dynamic vertex and edge insertion/removal and union-find cycle detection.

---

###  Concepts Covered

- Graph representation using object-oriented design (Vertex, Edge)
- Union-Find for cycle detection
- Kruskal’s algorithm for Minimum Spanning Tree (MST)
- Brelaz graph coloring algorithm
- Dynamic insertion and deletion of edges and vertices
- Modular and extensible graph components

---

### Files Overview

- `Graph.java` – Main graph logic including MST, coloring, cycle detection, and edge management
- `Vertex.java` – Vertex class with adjacency tracking and comparison methods
- `Edge.java` – Edge class with weight and vertex references, implements sorting logic
- `Main.java` – Contains tests for various graph configurations, performance checks, and visualizer exports  

## Sorting Framework (Prac8)


This practical implements a generic Java sorting framework with three classic algorithms: **QuickSort**, **MergeSort**, and **CountSort**. Each algorithm extends a common abstract base class and supports sorting arrays of `Comparable` objects. The main class runs all three sorts and compares outputs.

---

### Concepts Covered

- Inheritance and abstract classes
- Generics with `Comparable<T>`
- QuickSort (partition-based, in-place)
- MergeSort (divide-and-conquer)
- CountSort (frequency-based)
- Recursion and array manipulation
- Code reuse and modular design

---

### Files Overview

- `Sort.java` – Abstract base class with common structure and utility methods
- `QuickSort.java` – Partition-based sorting implementation
- `MergeSort.java` – Recursive merge sort with subarray splitting and merging
- `CountSort.java` – Integer-based counting sort using hash codes
- `App.java` – Test harness that runs all sorting algorithms and prints results

## Sudoku Solver Framework (Assignment 1)


This project implements a fully object-oriented **Sudoku Solver** in Java. It supports Sudoku boards of varying sizes (e.g. 3x3, 4x4, 2x3) and uses logical strategies to solve them. The board is constructed from a text file and the solver applies techniques like sole candidates, unique candidates, and duplicate cell elimination.


###  Concepts Covered

- 2D grid representation using linked `Cell` structures
- Logical deduction techniques for solving Sudoku
- File I/O and board parsing from `.txt` files
- Custom `List<T>` and `Node<T>` implementations
- Object-oriented design: classes for board, cell, list, and solver
- Modular testing and console output formatting

---

### Files Overview

- `Board.java` – Core logic for Sudoku grid construction, solving, and propagation
- `Cell.java` – Represents individual Sudoku cells with possible values
- `List.java` – Custom singly linked list used for tracking possibilities
- `Node.java` – Generic node for `List<T>`
- `SudokuSolver.java` – Parses the board from file and runs the solving logic
- `Main.java` – Task runner with colorful output and multiple test cases
---
## Treap (Tree + Heap) Implementation (Assignment 2)


This practical implements a **Treap** — a randomized binary search tree that also maintains heap properties. It allows efficient insertions, deletions, and access operations by assigning random priorities to nodes and performing tree rotations to maintain balance.

---

###  Concepts Covered

- Binary Search Tree (BST) and Heap combination
- Tree balancing through rotations
- Randomized priority management
- Recursive insertion and deletion
- Exception handling (e.g. duplicate insertions)
- Generic node and tree implementation

---

###  Files Overview

- `Treap.java` – Main class with insert, delete, access, and balancing logic
- `Node.java` – Node structure with value, priority, and child/parent references
- `Database.java` – Utility class for building and managing multiple Treaps
- `Cell.java` – Represents user input entries (e.g. student/course pairs)
- `Main.java` – Driver class for demonstrating Treap operations and dataset setup
  
