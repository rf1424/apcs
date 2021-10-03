/*
Rin Fukuoka
APCS
HW08 
*/

/*
Discoveries: 
"error: reached end of file while parsing" means that
the number of opening and closing parentheses do not match. 

Unsolved Questions:
What does Greet.class represent? 
Is it not supposed to be there?
*/


public class Greet {
public static void greet(String name) {
System.out.println("Why, hello there, " + name + ". How do you do?");
}
public static void main(String[] args) {
greet("Julia");
greet("Ethan");
greet("Mr. Mykolyk");
}
}
