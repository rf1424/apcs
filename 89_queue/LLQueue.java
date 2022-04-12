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

import java.util.LinkedList;

public class LLQueue<QUASAR> implements Queue<QUASAR> {
    private LinkedList<QUASAR> _array;

    public LLQueue(){
        _array = new LinkedList<QUASAR>();
    }

    public QUASAR dequeue(){
        return _array.remove(0);
    } //O(1)

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( QUASAR x ){
        _array.add(_array.size(), x);
    } //O(1)

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
        return _array.isEmpty();
    }

    //Returns the first element of the queue without dequeuing it.
    public QUASAR peekFront(){
        return _array.peek();
    }

    public String toString(){
        return _array.toString();
    }

}
