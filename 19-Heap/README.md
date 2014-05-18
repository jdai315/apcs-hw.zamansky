Driver class:
- to run, compile with an Integer input which indicates size of the Maps
- tests the put() and remove() methods of both Hash and Tree maps
- some findings:
  - Hash puts new value/key pairs faster on smaller sizes
  - as size gets larger, Hash and Tree perform similarly
  - remove() methods perform similar times for all values
  - program runs out of Heap memory past one million large maps


Hash

1) HashMap vs. HashSet

HashMap
- implements the Map interface
- unique keys that may have duplicate values
- user specifies a key to put a value in (key-value pair)
- accepts a null key and null value
- not synchronized

HashSet
- implements the Set interface
- unique keys with no duplicate values
- user gives a value and a key is already set aside for it from the hash function (value only)
- uses a map to store values

Implementation
HashMap
- a main array where each index contains a Linked List that stores the key and value
- length is always a power of 2

TreeMap
- a binary search tree (where each node is either red or black)

Heaps In Java
PriorityQueue


