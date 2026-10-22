# User-Defined Linked Lists in Java

Simple, classroom-style implementations of three linked-list types. All nodes store **int** values by default, keeping the code easy to follow.

- **Singly Linked List** — each node points to the next node.
- **Doubly Linked List** — each node points to both the previous and next nodes.
- **Circular Singly Linked List** — the last node points back to the first node.

## Files

| File | Description |
| --- | --- |
| SinglyLinkedList.java | Contains SNode and SLL. |
| DoublyLinkedList.java | Contains DNode and DLL. |
| CircularLinkedList.java | Contains CNode and CLL. |
| Main.java | Demonstrates the operations on all three lists. |

## Operations

Each list supports:

- `insertFirst(int val)` — insert at the beginning.
- `insertLast(int val)` — insert at the end.
- `insertAt(int index, int val)` — insert at a zero-based index.
- `deleteFirst()` — remove and return the first value.
- `deleteLast()` — remove and return the last value.
- `deleteAt(int index)` — remove and return the value at an index.
- `search(int val)` — check whether a value exists.
- `length()` — return the number of nodes.
- Display methods. The doubly linked list can display both forward and backward.

## Indexing and edge cases

Indexes start at 0. Insertion accepts indexes from 0 through `length()`; deletion accepts indexes from 0 through `length() - 1`. Invalid indexes are reported and do not change the list. If deletion is attempted on an empty list or with an invalid index, the method prints a message and returns `-1`. Since `-1` can also be a valid list value, check the list or index before deleting if this distinction matters.

## Run the program

Install a JDK, open a terminal in the repository folder, and run:

~~~bash
javac *.java
java Main
~~~

## Example

~~~java
SLL list = new SLL();
list.insertFirst(10);
list.insertLast(30);
list.insertAt(1, 20);
list.display();                    // 10 -> 20 -> 30 -> null
System.out.println(list.length()); // 3
list.deleteAt(1);
list.display();                    // 10 -> 30 -> null
~~~
