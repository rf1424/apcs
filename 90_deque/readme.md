// Team FRED - Andrey Sokolov + Geese & Rin Fukuoka + Tape, Kartik Vanjani + Krish
// APCS pd8
// HW90/91 - KAchoo Deque
// 2022-04-12/13
// time spent: 0.5 hours

#PLAN 2022-04-12
- finish reading through the oracle documentation of deque
- figure out the methods we implement
- put these methods in the interface according to priority and ability:
    - add
    - addFirst
    - addLast
    - remove
    - removeFirst
    - removeLast
    - size
    - toString
    - contains
- implement these methods inside the QQKachoo class, and test them inside a main()

#PLAN 2022-04-13
- put these methods in the interface according to priority and ability:
    - peek
    - peekFirst
    - peekLast
    - pop
    - removeFirstOccurence
    - removeLastOccurence

#DESIGN CHOICES
- We've decided to make Deque a wrapper class of LinkedList, due to the fact that LinkedList implements all of the methods of the official Deque interface.
- We've decided not to implement all of the methods from the official Deque interface in our interface in order to save time
