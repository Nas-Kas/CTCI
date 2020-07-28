/*
How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time. 

keep a pointer to the last min index?
how to do it without nlogn sorting?
how to deal with duplicates?

build a stack with a min pointer
build an arraylist that holds the pointer to the last min
every time we remove a value check if the next previous min is less than current min
if so update the min 
otherwise do nothing

currently doesnt work with negative numbers? how to fix?
*/
import java.util.*;

public class minStack{
    Stack<Integer> st = new Stack<Integer>();
    ArrayList<Integer> minList = new ArrayList<Integer>();
    
    int push(int value){
        if(getMin() == -1 || getMin() >= value){
            st.push(value);
            minList.add(value);
            return value;
        }else if(getMin() < value){ // if our current min is less than value
            st.push(value);
            return value;
        }
        return -1;
    }

    int pop(){
        if(st.isEmpty()){
            return -1;
        }
        int val = st.pop();
        if(val == minList.get(minList.size() - 1)){
            minList.remove(minList.size() - 1);
            return val;
        }
        return -1;
    }

    int getMin(){
        if(st.isEmpty()){
            return -1;
        }else{  
            return(minList.get(minList.size() - 1));
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