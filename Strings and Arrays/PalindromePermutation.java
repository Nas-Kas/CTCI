/*
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words. 

Tact Coa 
return true if there exists a permutation that is a palindrome?
"taco cat", atco eta" are two examples

my example
anna - true
    possible perms: nana, nnaa, aann

vs
annabelle
    true: aannlleeb
          [2,2,2,2,1]

Possible solution: generate all permutations then check if the permutation is a palindrome
    - generate all permutation n^2 time
    - check if its a palindrome O(n) time

Possible solution: sort strings and match pairs or triplets?
    - how to be a palindrome all even pairs
    - all even pairs and one odd pair
    - all odd pairs
    - all odd pairs and one even pair
    - all odd pairs and one odd pair
Question?
- how do we deal with uppercase, lowercase, punctutation?

frequency hashmap<char,int> top down approach with all data
- put frequency into int arraylist 
- sort arraylist
- move through arraylist removing matches
- if arraylist at the end is of size 0 or 1 return true
- otherwise return false;

bottom up approach building a palindrome
- find a pair
- put them together
- if no pair increment oddcount and move on
    -if oddcount exceeds 1 return false


easiest solution use a set and add and remove characters as you pass them
if the sets size is greater than 2 at the end return false otherwise return true
*/
import java.util.*;

class PalindromePermutation{
    public static boolean setSoln(String input){
        HashSet<Character> set = new HashSet<Character>();
        input = input.toLowerCase();
        for(int i = 0; i < input.length(); i++){
            char curr = input.charAt(i);
            if(set.contains(curr)){
                set.remove(curr);
            }else{
                set.add(curr);
            }
        }
        if(set.size() > 2){
            return false;
        }
        return true;
    }

    public static boolean bottomUp(String input){
        ArrayList<Integer> pairs = mapTopair(mapify(input));
        if(pairs.size() <= 1){
            return true;
        }
        int oddCount = 0;
        for(int i = 0; i < pairs.size(); i++){
            if(pairs.get(i) == 1 || pairs.get(i)%2 != 0){
                oddCount++;
            }
            if(oddCount > 1){
                return false;
            }
        }
        return true;
    }
    public static HashMap<Character,Integer> mapify(String input){ // convert string to map
        HashMap<Character,Integer> freq = new HashMap<Character,Integer>();
        input = input.toLowerCase();
        for(int i = 0; i < input.length(); i++){
            char curr = input.charAt(i);
            if(Character.isWhitespace(curr)){
                continue;
            }
            else if(freq.containsKey(curr)){
                freq.put(curr, freq.get(curr) + 1);
            }else{
                freq.put(curr,1);
            }
        }
        return freq;
    }

    public static ArrayList<Integer> mapTopair(HashMap<Character,Integer> map){ // convert map to freq arraylist
        ArrayList<Integer> pairs = new ArrayList<Integer>();
        for(char x : map.keySet()){
            pairs.add(map.get(x));
        }
        Collections.sort(pairs);
        return pairs;
    }
    public static void main (String[]args){
        String a = "Stats"; // true
        String b = "Sagas"; // true
        String c = "Repa per"; // true
        String d = "future"; // false
        String e = "failures"; // false
        String f = "INsdfe cto ry"; // false
        String g = ""; // true
        String h = "!!!!????!"; // true
        //System.out.println(bottomUp(a));
        //System.out.println(bottomUp(b));
        //System.out.println(bottomUp(c));
        //System.out.println(bottomUp(d));
        //System.out.println(bottomUp(e));
        //System.out.println(bottomUp(f));

        System.out.println(setSoln(a));
        System.out.println(setSoln(b));
        System.out.println(setSoln(c));
        System.out.println(setSoln(d));
        System.out.println(setSoln(e));
        System.out.println(setSoln(f));
        System.out.println(setSoln(g));
        System.out.println(setSoln(h));

    }
}