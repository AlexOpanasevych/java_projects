
import java.util.*;

/*13.	Перевірити, чи є в списку  послідовність з трьох парних елементів.
 *
 *
 *
 *  */


public class List{
    public static void checkSequence(List<Integer> list){
        int counter = 0;

        for (Integer i:
                list) {
            if (i.intValue() % 2 == 0){
                counter++;
            }
            else{
                counter = 0;
            }
            if (counter == 3){
                System.out.println("List contains sequence of 3 prime numbers");
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> singly_list = new ArrayList<Integer>();

        singly_list.add(2);
        singly_list.add(4);
        singly_list.add(4);
        singly_list.add(5);
        singly_list.add(6);
        singly_list.add(7);
        singly_list.add(8);

        System.out.println(singly_list);

        if (singly_list.contains(5)){
            int i = singly_list.indexOf(5);
            singly_list.remove((Integer)5);
            int temp = singly_list.get(i);
            singly_list.set(i, singly_list.get(i + 1));
            singly_list.set(i + 1, temp);
        }
        System.out.println("After deletion " + singly_list);

        checkSequence(singly_list);

        List <Integer> doubly_list = new LinkedList<>();
        doubly_list.add(10);
        doubly_list.add(8);
        doubly_list.add(6);
        doubly_list.add(5);
        doubly_list.add(4);

        System.out.println(doubly_list);

        if (doubly_list.contains(5)){
            doubly_list.remove((Integer)5);
        }

        System.out.println(doubly_list);

        checkSequence(doubly_list);
    }
}