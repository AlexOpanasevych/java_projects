/*Дано послідовність, що містить від 2 до 50 слів, 
у кожному з яких від 1 до 8 рядкових латинських букв; 
між сусідніми словами - не менш одного пробілу, 
за останнім словом - крапка. Надрукувати ті слова послідовності, 
які відмінні від першого слова й задовольняють наступній властивості:
букви слова впорядковані за алфавітом*/
// defin edit adept
public class lab_ASD{
    private static boolean isInOrder(char previous, char[] arr) {
        for (char current : arr) {
            if (current < previous)
                return false;
            previous = current;
        }
        return true;
    }

    public static void correctWords(String[] wrds) {
        char previous;
        for (String var : wrds) {
            if(!var.equals(wrds[0])){
                previous = var.charAt(0);
                if(isInOrder(previous, var.toCharArray())) System.out.println(var);
            }
        }
    }
    public static void main(String[] args) {
        String words = System.console().readLine();
        String[] wrds = words.split("[ .]");
        if (wrds.length < 2 || wrds.length > 50) {
            return;
        }
        for (String var : wrds) {
            if (var.isEmpty() || var.length() > 8) {
                return;
            }
        }
        correctWords(wrds);
    }
}