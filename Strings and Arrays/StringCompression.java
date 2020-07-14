
/*
 Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z)

AAbaaAcDeF --> A2ba2AcDeF
         *
F
count = 1
"A2ba2AcDeF"
AAAAA -> A5
"" -> ""
- create a new string

- loop through keeping count of curr char
    - if curr char is repeated
       - add to result string 
       - update count
        -if count is 1 just add char otherwise add char and val
       - update curr char
    - if char is not repeated

*/
public class StringCompression {
    public static String strCompress(String input){
        if(input.length() <= 1){
            return input;
        }
        char curr = input.charAt(0);
        int count = 1;
        String res = "";
        for(int i = 0; i < input.length() - 1; i++){
            curr = input.charAt(i);
            if(curr == input.charAt(i + 1)){
                count++;
            }
            else if(curr != input.charAt(i + 1)){
                res = res + curr + "" + count;
                count = 1;
            }
        }
        String last = curr + "" + count;
        String end = res.substring(res.length() - last.length(),res.length());
        if(!last.equals(end)){
           res += last;
        }
        if(res.length() > input.length()){
            return input;
        }
        return res;
    }

    public static void main (String [] args){
        String a = "asdfdddddddd";
        System.out.println(strCompress(a));
        
    }
}