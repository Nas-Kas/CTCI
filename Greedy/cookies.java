/*
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. 
Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. 
If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content 
children and output the maximum number.

Example 1
 children [1,2,3]
 cookies  [1,1]

 output 1
Example 2

 children [1,2] 
 cookies  [1,2,3]

output 2

1 - sort both arrays in ascending order
2 - one pointer for children and one for cookies
3 - if child <= cookie pointer
    - increment count by 1
    - increment child pointer
    - incremetn cookie pointer
  - if child > cookie pointer
    - increment cookiepointer

example

 child  [1,1,4,5]
             *
 cookie [2,2,3]
             *
 count - 2
 expect to return 2

*/
import java.util.*;

public class cookies {
    public static int findContentChildren(int [] cookies, int [] children){
        Arrays.sort(cookies);
        Arrays.sort(children);
        int cookieP = 0;
        int childP = 0;
        int count = 0;
        while(childP < children.length && cookieP < cookies.length){
            if(children[childP] <= cookies[cookieP]){
                count++;
                childP++;
                cookieP++;
            }
            else if(children[childP] > cookies[cookieP]){
                cookieP++;
            }
        }
        return count;
    }

    public static void main (String [] args){
        int [] t1 = new int [] {1,2,3};
        int [] t2 = new int [] {1,1};
        int [] t3 = new int [] {1,2};
        int [] t4 = new int [] {1,1,4,5};
        int [] t5 = new int [] {2,2,3};
        System.out.println(findContentChildren(t2,t1)); // expected 1
        System.out.println(findContentChildren(t1,t3)); // expected 2
        System.out.println(findContentChildren(t5,t4)); // expected 2
    }
}