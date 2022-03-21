//TNPG stingRAY: Rin Fukuoka, Abdullah Faruque, Yuki Feng
//APCS pd08
//Lab06
//02-10-22

public class activity5{

    public static String joemama(String joe){
        String[] mama = joe.split(" ");
        String withVowel = "";
        String withoutVowel = "";
        for (int i = 0; i < mama.length; i ++){
            if (hasVowel(mama[i])){
                withVowel +=" " + mama[i];
            } else {
                withoutVowel += " " + mama[i];
            }
        }
        return (withVowel+withoutVowel);
    }

    public static boolean hasVowel(String doomah){
        String vowels = "AEIOUaeiou";
        for (int i = 0; i < vowels.length(); i++){
            if(vowels.charAt(i)==doomah.charAt(0)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(joemama("The quick brown fox jumps over the lazy dog."));
    }


}
