/**
 * Створити стек символів. Порахувати чого більше у стеці – літер «а» чи «о».
 * Stack
 */
public class Stack {
    char [] array;
    int index;
    Stack(){index = 0;}
    Stack(char start){
        push(start);
    }
    public void push(char elem){
        char [] temp = array;
        array = new char[index + 1];
        for (int i = 0; i < index; i++) {
            array[i] = temp[i];
        }
        array[index] = Character.toLowerCase(elem);
        index++;
    }
    
    public char pop(){
        return array[index--];
    }

    public char get(){
        return array[index];
    }

    public char get(int i){
        return array[i];
    }

    public void print(){
        for (int i = index - 1; i > -1; i--) {
            System.out.println(array[i] + " ");
        }
    }

    public void checkChars(){
        int c1 = 0, c2 = 0;
        for (int i = 0; i < index; i++) {
            if (array[i] == 'a') {
                c1++;
            }
            if(array[i] == 'o'){
                c2++;
            }
        }
        if (c1 > c2) {
            System.out.println("char 'a' is presented more times than 'o'");
        }
        else if(c1 == c2){
            System.out.println("char 'a' equals times than 'o'");
        }
        else{
            System.out.println("char 'o' is presented more times than 'a'");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 26; i++) {
            if(i == 10){
                stack.push('a');
            }
            stack.push((char)(i+65));
        }
        stack.print();
        stack.checkChars();
    }
    
}