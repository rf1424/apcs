// Team FRED - Andrey Sokolov + Geese & Rin Fukuoka + Tape, Kartik Vanjani + Krish
// APCS pd8
// HW90/91 - KAchoo Deque
// 2022-04-13
// time spent: 0.5 hours

public class MRKPirateBae {
    public static void main(String[] args){
        //props to THEODORE YOCHUM for writing this lovely main like 3 weeks ago :D

        //test add at first
        QQKachoo<Integer> test = new QQKachoo<Integer>();
        for (int i = 0; i < 15; i++) {
          test.addLast(i);
        }
        System.out.println("Should print a deque of numbers 0 to 14 in linear order incrementing by 1");
        System.out.println(test);

        //test add at end
          QQKachoo<Integer> test2 = new QQKachoo<Integer>();
          for (int i = 0; i < 15; i++) {
            test2.addFirst(i);
          }
          System.out.println("Should print a deque of numbers 14 to 0 in reverse linear order deceremnting by 1");
          System.out.println(test2);

        //test remove at first
        test.removeFirst();
        test.removeLast();
        System.out.println("Remove first and last elements, which are 0 and 14");
        System.out.println(test);

        //test contains
        System.out.println("testing contains:");
        System.out.println(test.contains(0)); //false
        System.out.println(test2.contains(0)); //true

        //test size
        System.out.println("testing size: " + test.size()); //13

        //test peek
        System.out.println("testing peek:");
        System.out.println(test.peek()); //1
        System.out.println(test.peekFirst()); //1
        System.out.println(test.peekLast()); //13

        //test pop
        System.out.println("testing pop:");
        System.out.println(test.pop()); //12

        //test remove at first/last occurences
        test2.addFirst(3);
        test2.addLast(6);
        System.out.println(test2.toString());
        test2.removeFirstOccurrence(3);
        System.out.println("removed first occ of 3: " + test2.toString());
        test2.removeLastOccurrence(6);
        System.out.println("removed last occ of 6: " + test2.toString());



      }//end of main

}//end of class
