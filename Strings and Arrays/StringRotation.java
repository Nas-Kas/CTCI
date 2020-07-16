
/*
Assumeyou have a method isSubstringwhich checks if oneword is a substring
of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat"). 

answer - put both original strings on top of each other and check if rotated is a substring
of the newly built string
*/

public class StringRotation {
    
    public static boolean isRotated(String original, String rotated){
        String newStr = original + original;
        return isSubstring(newStr,rotated);
    }


    public static boolean isSubstring(String s1, String s2){
        return(s1.contains(s2));
    }
    public static void main (String [] args){
        String o = "waterbottle";
        String r = "erbottlewat";
        System.out.println(isRotated(o,r));

        String o1 = "baconeggsandwaffles";
        String r1 = "wafflesbaconeggsand";
        System.out.println(isRotated(o1,r1));

        String o2 = "gritsgoopandggravy";
        String r2 = "gravygritsgoopandx";
        System.out.println(isRotated(o2,r2));
    }
}