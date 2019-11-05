
// Вивести в алфавітному порядку для даного тексту приголосні літери, які входять тільки в одне слово.
// A, E, I, O, U, Y.
import java.util.HashMap; // for hash map
import java.util.LinkedList;
import java.util.Map; // for map
import java.util.ArrayList;
public class SecondLab{
    private static Map<Character, Boolean> nonRepeatedLetters;

    public static ArrayList<String> buildRightArray(String [] words){
        ArrayList<String> rightStrings = new ArrayList<String>();
        for (String word : words) {
            if (!rightStrings.contains(word)) {
                rightStrings.add(word);
            }
        }
        System.out.println(rightStrings);
        return rightStrings;
    }

    public static void printLetters(String[] words) {
        nonRepeatedLetters = new HashMap<Character, Boolean>();
        ArrayList<String> rightStrings = buildRightArray(words);
        ArrayList<Character> repeatedLetters = new ArrayList<Character>();
        for (char i = 'a'; i < 'z'; i++) {
            if(i != 'a' && i != 'e' && i != 'i' && i != 'o' && i != 'u' && i != 'y') nonRepeatedLetters.put(i, false);
        }
        for (int i = 0; i < rightStrings.size(); i++) {
            if(i < rightStrings.size() - 1){
                for (int j = i + 1; j < rightStrings.size(); j++) {
                    for (int l = 0; l < rightStrings.get(i).length(); l++) {
                        if ((rightStrings.get(j).indexOf(rightStrings.get(i).charAt(l)) == -1) && 
                            nonRepeatedLetters.containsKey(rightStrings.get(i).charAt(l)) && 
                                !repeatedLetters.contains(rightStrings.get(i).charAt(l))){
                            nonRepeatedLetters.replace(rightStrings.get(i).charAt(l), true);
                            //System.out.println("Letter " + rightStrings.get(i).charAt(l) + " isn't in word " + rightStrings.get(j));
                        }
                        else {
                            repeatedLetters.add(rightStrings.get(i).charAt(l));
                            nonRepeatedLetters.replace(rightStrings.get(i).charAt(l), false);
                        }
                    }
                }
            }
            else{
                for (int j = i - 1; j > 0; j--) {
                    for (int l = 0; l < rightStrings.get(i).length(); l++) {
                        if ((rightStrings.get(j).indexOf(rightStrings.get(i).charAt(l)) == -1 ) && 
                            nonRepeatedLetters.containsKey(rightStrings.get(i).charAt(l)) && 
                            !repeatedLetters.contains(rightStrings.get(i).charAt(l))){
                            nonRepeatedLetters.replace(rightStrings.get(i).charAt(l), true);
                            //System.out.println("Letter " + rightStrings.get(i).charAt(l) + " isn't in word " + rightStrings.get(j));
                        }
                        else{
                            repeatedLetters.add(rightStrings.get(i).charAt(l));
                            nonRepeatedLetters.replace(rightStrings.get(i).charAt(l), false);
                        } 
                    }
                }
            }
        }
        
        for (Map.Entry<Character, Boolean> entry : nonRepeatedLetters.entrySet()){
            if(entry.getValue() == true) System.out.print(entry.getKey() + " "); 
        }
    }

    public static void main(String[] args) {
        String str = System.console().readLine();
        str = str.toLowerCase();
        String[] words = str.split("[ ,.]");
        printLetters(words);
    }
}