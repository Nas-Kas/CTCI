

/*
One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away. 

given two strings you need to add remove or replace one character in a second string
to get the first string if you cannot do that return false

(hat,cat) -> change c and get matching strings so true
(pepper, peppe) -> add r and get matching so true
(flag, flags) -> remove s to get flag matching true

(syrupy, syxrupy)
      *        *
keep a edit count
- check if the strings are the same length
    - then you know we can only replace 
    - iterate over keepting a edit count
    - if editcount > 1 return false
- if strings differ by one
    - then we implement a remove method on the longer string
    - iterate over the shorter string until you find a differing character
        -increment edit count

*/

public class OneAway {
    public static boolean oneOff(String a, String b){ // assume string a is longer than string b
        int editCount = 0;
        if(a.equals(b)){
            return true;
        }
        if(Math.abs(a.length() - b.length()) > 1){
            return false;
        }
        if(a.length() == b.length()){// replace
            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) != b.charAt(i)){
                    editCount++;
                }
                if(editCount > 1){
                    return false;
                }
            }
        }
        else{
            int aPointer = 0;
            int bPointer = 0;
            while(bPointer < b.length()){
                if(a.charAt(aPointer) != b.charAt(bPointer)){
                    aPointer++;
                    editCount++;
                }else{
                    aPointer++;
                    bPointer++;
                }
                if(editCount > 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main (String [] args){
        String a = "pale";
        String b = "ple";
        String c = "pales";
        String d = "bale";
        String e = "syrupy";
        String f = "syxrupy";
        System.out.println(oneOff(a,b));//true
        System.out.println(oneOff(c,a));//true
        System.out.println(oneOff(a,d));//true
        System.out.println(oneOff(f,b));//false
        System.out.println(oneOff(f,e));//true

    }
}