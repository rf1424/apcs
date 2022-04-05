public class LLNode<QUASAR>{
    //instance vars
    private QUASAR cargo;
    private LLNode<QUASAR> cdr;

    // constructor
    public LLNode( QUASAR value, LLNode<QUASAR> next )
    {
        this.cargo = value;
        this.cdr = next;
    }

    public LLNode( QUASAR cargo) {
        this.cargo = cargo;
        this.cdr = null;
    }


    //--------------v  ACCESSORS  v--------------
    public QUASAR getCargo()
    {
        return this.cargo;
    }

    public LLNode<QUASAR> getNext()
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

    public LLNode<QUASAR> setNext( LLNode<QUASAR> newNext )
    {
        LLNode<QUASAR> temp = this.cdr;
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
