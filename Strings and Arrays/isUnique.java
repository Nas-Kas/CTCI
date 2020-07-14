/*
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures? 

what do we mean by unique is a == A is " " a unique character etc.
with data structures we can simply use a hashset
- use hashset to store current char
- do a lookup on current char for every iteration over the string

without data structures we can use an On^2 algorithm that checks each value for duplicate values in the array
 - two for loops looking for duplicate chars
 - return false if found them
 - return true if exit loop
if we can change the data structure we can sort it and just do pairwise search with two pointers next to each other (n log (n))
- nlogn is the fastest a string can be sorted
- sort the string
- use two pointers next to each other and iterate over the string
*/

import java.util.*;

public class isUnique {
    public static boolean setApproach(String input){ // o n^2 because for each character you're doing a set lookup
        input = input.toLowerCase();
        HashSet<Character> chars = new HashSet<Character>();
        for(int i = 0; i < input.length(); i++){
            if(chars.contains(input.charAt(i))){
                return false;
            }
            else{
                chars.add(input.charAt(i));
            }
        }
        return true;
    }

    public static boolean loopApproach(String input){ // o n^2 without extra space
        input = input.toLowerCase();
        for(int i = 0; i < input.length(); i++){
            for(int j = i + 1; j < input.length(); j++){
                if(input.charAt(i) == input.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean twoPointer(String input){ // nlogn time whenever someone say nlogn think string sorting because that is the fastest way a string can be sorted
        input = input.toLowerCase();
        char [] c = input.toCharArray();
        Arrays.sort(c);
        input = String.valueOf(c);
        int p1 = 0;
        int p2 = 1;
        while(p2 < input.length()){
            if(input.charAt(p1) == input.charAt(p2)){
                return false;
            }
            p1++;
            p2++;
        }
        return true;
    }

    public static void main (String[]args){
        String a = "test";
        String b = "TesT aadv";
        String c = "Abdce fg";
        String d = "a";
        System.out.println(setApproach(a)); // false
        System.out.println(setApproach(b)); // false
        System.out.println(setApproach(c)); // true
        System.out.println(setApproach(d)); // true

        System.out.println(loopApproach(a));
        System.out.println(loopApproach(b));
        System.out.println(loopApproach(c));
        System.out.println(loopApproach(d));

        System.out.println(twoPointer(a));
        System.out.println(twoPointer(b));
        System.out.println(twoPointer(c));
        System.out.println(twoPointer(d));
        
    }
}