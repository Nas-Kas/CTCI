/*
Given two strings, write a method to decide if one is a permutation of the
other. 
Question
- do we care about spaces? do we care about uppercase? how do we handle punctuation


1. check if two hashmaps are the same
 - mapify method // takes O(n) time for each string
 - check for object equality // 
2. sort two strings and check for equality // sorting takes nlogn time iterating takes O(n) time very optimal solution
 - sort by turning into a char array and back
 - check for string equality
3. use arrays instead of hashsets and check for equality // possible use less space than map if only using one array
 - use array of size 256 to store char ascii values as you traverse


*/
import java.util.*;

public class checkPermutation  {
    public static boolean mapSolution(String a, String b){
        return mapify(a).equals(mapify(b));
    }

    public static HashMap<Character,Integer> mapify(String input){
        HashMap<Character,Integer> output = new HashMap<Character,Integer>();
        input = input.toLowerCase();
        for(int i = 0; i < input.length(); i++){
            Character curr = input.charAt(i);
            if(output.containsKey(curr)){
                output.put(curr, output.get(curr) + 1);
            }else{
                output.put(curr,1);
            }
        }
        return output;
    }


    public static boolean sortSolution(String a, String b){
        a = stringSort(a);
        b = stringSort(b);
        return a.equals(b);
    }

    public static String stringSort(String a){
        a = a.toLowerCase();
        char [] arr = a.toCharArray();
        Arrays.sort(arr);
        String res = String.valueOf(arr);
        return res;
    }

    public static boolean arrSolution(String a, String b){
        int [] arr = bitArr(a);
        int [] brr = bitArr(b);
        return Arrays.equals(arr,brr);
    }

    public static int [] bitArr(String a){
        a = a.toLowerCase();
        int [] arr = new int [256];
        for(int i = 0; i < a.length(); i++){
            arr[a.charAt(i)]++;
        } 
        return arr;
    }


    public static void main (String [] args){
        String a = "abcd";
        String b = "defg";
        String c = "ABCD EF";
        String d = "BAc dEf";
        System.out.println(mapSolution(a,a)); // true
        System.out.println(mapSolution(a,b)); // false
        System.out.println(mapSolution(c,d)); // true

        System.out.println(sortSolution(a,a));
        System.out.println(sortSolution(a,b));
        System.out.println(sortSolution(c,d));
        
         System.out.println(arrSolution(a,a));
         System.out.println(arrSolution(a,b));
         System.out.println(arrSolution(c,d));
    }
}