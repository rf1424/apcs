/**
 * Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 * APCS PD8
 * HW 89: McDonald's Drive-thrus
 * 2022-04-11
 * Spent: 0.5 hrs
 *
 * DISCO
 * - its interesting how the code for one wrapper works as the code for the other wrapper method
 * - thank god for isEmpty() being an actual function
 *
 * QCC
 * - is there a more optimized way to create a dequeue() method for LLQueue??
 * - are all classes implementing List interface this easy to make into queues?
 *
 *
 **/

 public class Driver {
    public static void main( String[] args )
    {


      Queue<String> PirateQueue = new LLQueue<String>();

      System.out.println("\nnow enqueuing...");
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Roberts");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");

      System.out.println("\nnow testing toString()...");
      System.out.println( PirateQueue ); //for testing toString()...

      System.out.println("\nnow testing peekFront()...");
      System.out.println( PirateQueue.peekFront() ); //for testing toString()...


      System.out.println("\nnow dequeuing...");
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );

      System.out.println("\nnow dequeuing fr empty queue...\n" +
                         "(expect NPE)\n");
      System.out.println( PirateQueue.dequeue() );
        /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
        ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main
}
