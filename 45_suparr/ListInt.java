/**
Cute Cyclops Cult | Faiza Huda, DHBert, DTTom, Tasnim Chowdhury, Rin Fukuoka, Mary, Tape
APCS
HW45 - Array of Titanium
2021-12-08
Time Spent: 0.3
DISCO
 - no body means no {} either
 - interface says what the class has to do not how
QCC
 - How do we specifically test the interface's methods and not the class when the class is supposed to have all of those methods?
 - Can you implement multiple interfaces at once?
**/

public interface ListInt{
	public void add( int newVal );
	public void add( int index, int newVal );
	public void remove( int index );
	public int size();
}
