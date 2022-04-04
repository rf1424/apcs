import java.util.NoSuchElementException;

/**
 * Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 * APCS PD8
 * HW 87: April Queues
 * 2022-04-01
 * Spent: 0.5 hrs
 *
 * DISCO
 * - NodeQueue is pretty easy to implement if you remember to follow the encapsulation diagram
 * - _head and _tail work pretty nicely together to keep track of the queue!
 *
 * QCC
 * - would you still be able to implement NodeQueue without a _tail?
 * - do we need any other private variables to keep track of stuff?
 *
 *
 *
 **/

public class NodeQueue<QUASAR> implements Queue<QUASAR>{
    private int size;
    private Node<QUASAR> _head;
    private Node<QUASAR> _tail;

    public NodeQueue(){
        _head = _tail = null;
        size = 0;
    }

    public NodeQueue(QUASAR cargo){
        _head = _tail = new Node<QUASAR>(cargo);
        size = 1;
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public QUASAR dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        QUASAR original = _head.getCargo();
        _head = _head.getNext();
        size--;
        return original;
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( QUASAR x ){
        Node<QUASAR> _oldTail = _tail;
        _tail = new Node<QUASAR>(x);
        if(isEmpty()) _head = _tail;
        else _oldTail.setNext(_tail);
        size++;
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
        return _head == null;
    }

    //Returns the size
    public int size(){
        return size;
    }

    //Returns the first element of the queue without dequeuing it.
    public QUASAR peekFront(){
        if(isEmpty()) return null;
        return _head.getCargo();
    }

    private class Node<QUASAR> {
        //instance vars
        private QUASAR cargo;
        private Node<QUASAR> cdr;

        // constructor
        public Node( QUASAR value, Node<QUASAR> next )
        {
            this.cargo = value;
            this.cdr = next;

        }

        public Node( QUASAR cargo) {
            this.cargo = cargo;
            this.cdr = null;
        }


        //--------------v  ACCESSORS  v--------------
        public QUASAR getCargo()
        {
            return this.cargo;
        }

        public Node<QUASAR> getNext()
        {
            return this.cdr;
        }
        //--------------^  ACCESSORS  ^--------------


        //--------------v  MUTATORS  v--------------
        public QUASAR setCargo( QUASAR newCargo )
        {
            QUASAR temp = this.cargo;
            this.cargo = newCargo;
            return temp;
        }

        public Node<QUASAR> setNext( Node<QUASAR> newNext )
        {
            Node<QUASAR> temp = this.cdr;
            this.cdr = newNext;
            return temp;
        }
        //--------------^  MUTATORS  ^--------------


        // override inherited toString
        public String toString()
        {
            return cargo.toString();
        }

    }

    public static void main(String[] args){
        NodeQueue<Integer> qq = new NodeQueue<Integer>(5);
        for(int i = 10; i < 100; i+= 10) qq.enqueue(i);
        System.out.println("size: " + qq.size);
        while(!qq.isEmpty()){
            System.out.println(qq.dequeue());
        }
        System.out.println("size: " + qq.size);
    }
}
