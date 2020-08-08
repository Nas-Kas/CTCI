import java.util.*;
/*
 Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and is Empty. 

sorted stack 1 [1]
temp stack 2 []
-
- we rev until the elements are greater than or equal then we refill sorted stack
push 
    - if value to push is greater than top of stack
        - put value in temp stack as "new head"
        - while sorted stack is not empty or top of sorted stack is <= "new head"
        - rev the elements
            - once rev is complete push them all back to sorted stack
pop
    - remove top of sorted stack
peek
    - look at top of sorted and return top
isEmpty (redundant??)
    - look at sorted and return isempty

*/

public class sortStack {
    Stack<Integer> sortedStack = new Stack<Integer>();
    Stack<Integer> tempStack = new Stack<Integer>();
    void push(int value){
        if(sortedStack.isEmpty()){
            sortedStack.push(value);
        }else if(value < sortedStack.peek()){
            while(!sortedStack.isEmpty() && value < sortedStack.peek()){
                tempStack.push(sortedStack.pop());
            }
            sortedStack.push(value);
            while(!tempStack.isEmpty()){
                sortedStack.push(tempStack.pop());
            }
        }else{
            sortedStack.push(value);
        }
    }
    void pop(){
        if(!sortedStack.isEmpty()){
            sortedStack.pop();
        }
    }
    int peek(){ // returns -1 in case that is empty
        if(!sortedStack.isEmpty()){
            return sortedStack.peek();
        }
        return -1;
    }
    boolean isEmpty(){
        return sortedStack.isEmpty();
    }
    void printStack(){
        System.out.println(sortedStack);
    }

    public static void main (String [] args){
        sortStack test = new sortStack();
        test.push(-1);
        test.push(-5);
        test.push(1);
        test.push(5);
        test.push(0);
        test.push(-10);
        test.push(99);
        test.printStack();
    }
}