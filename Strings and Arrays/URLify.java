/*
Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.) 
Questions
 - how to deal with duplicate spaces?
 - how to deal with empty string or empty space case

non-inplace - rebuild string but if you see a " " insert a "%20" then return new string

*/

public class URLify {
    public static String url(String input){
        String res = "";
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                res += "%20";
            }else{
                res += input.charAt(i);
            }
        }
        return res;
    }

    public static void urlinPlace(char [] str, int length){
        int end = str.length - 1;
        int charP = str.length - 1;
        while(Character.isWhitespace(str[charP])){
            charP--;
        }
        while(charP > 0 && end > 0){
            if(Character.isWhitespace(str[charP])){
                str[end] = '0';
                end--;
                str[end]  = '2';
                end--;
                str[end] = '%';
                end--;
                charP--; 
            }else{
                str[end] = str[charP];
                end--;
                charP--;
            }
        }
    }
    public static void main (String [] args){
        String a = "";
        String b = " ";
        String c = "a big fat pizza";
        String d = "HELLO  WORLD";
        char [] str = new char [] {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
        urlinPlace(str, str.length);

        //System.out.println(url(a));
        //System.out.println(url(b));
        //System.out.println(url(c));
        //System.out.println(url(d));
    }
}