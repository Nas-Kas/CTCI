/*
How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time. 

keep a pointer to the last min index?
how to do it without nlogn sorting?
how to deal with duplicates?

(brainstorming)
build a stack with a min pointer?? 
build an arraylist that holds the pointer to the last min (sort of)
every time we remove a value check if the next previous min is less than current min
if so update the min 
otherwise do nothing

(correct approach)
use two stacks or equally valid to use a stack and an arraylist - two stacks is easier to manage b/c built in methods

*/
import java.util.*;

public class minStack{
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> minList = new Stack<Integer>();
    
    void push(int value){
        if(st.isEmpty() || value <= minList.peek()){
            minList.push(value);
        }
        st.push(value);
    }
    void pop(){
        if(!st.isEmpty() && st.peek() == minList.peek()){
            minList.pop();
        }
        st.pop();
    }
    int getMin(){
        if(!minList.isEmpty()){
            return minList.peek();
        }else{
            System.out.println("element needs to be inserted");
            return -1;
        }
    }
    

    public static void main (String [] args){
        minStack test = new minStack();
        System.out.println(test.getMin()); // - 1
        test.push(3);
        System.out.println(test.getMin()); // 3
        test.push(2);
        System.out.println(test.getMin()); // 2
        test.push(1);
        System.out.println(test.getMin()); // 1
        test.push(2);
        System.out.println(test.getMin()); // 1
        test.push(1);
        System.out.println(test.getMin()); // 1
     
        test.pop();
        test.pop();
        System.out.println(test.getMin()); // 1
        System.out.println(Arrays.toString(test.st.toArray())); // [3,2,1]
        
    }
}