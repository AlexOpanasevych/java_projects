package com.company;

/**
 * fourthLab
 */
public class RemoveSpaces {

    public static void removeSpacesRecursively(char [] arr, int i){
        if(i == arr.length || i + 1 == arr.length){
            return;
        }
        if(arr[i] == ' ' && arr[i+1] == ' ') {
            for (int j = i; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = '\0';
            removeSpacesRecursively(arr, i);
        }
        else{
            removeSpacesRecursively(arr, i + 1);
        }
    }
    /*(symbol <= 'z' && symbol >= 'a') || (symbol >= 'A' && symbol <= 'Z')*/
    public static char[] removeSpacesIteratively(String str){
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            while (arr[i] == ' ' && arr[i+1] == ' '){
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = '\0';
            }
        }
        return arr;
    }



    public static void main(String[] args) {
        String str = "This    is   a   test   for  test";
        char [] arr = removeSpacesIteratively(str);
        System.out.println(arr);
        char [] arr2 = str.toCharArray();
        removeSpacesRecursively(arr2, 0);
        System.out.println(arr2);
    }
}