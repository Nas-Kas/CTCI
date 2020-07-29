import java.util.*;
/*
 Implement a MyQueue class which implements a queue using two stacks
 stack LIFO
 queue FIFO

 queue methods
    enqueue

    dequeue

ex stack push[1,2,3]
        

q  2, 3

s1 2,3
s2
one stack for holding values 
one stack for removing
    - when we add someting just put in stack 1
    - when we need to remove something use stack 2 to reverse
        - remove the last element in stack 1
        - 
*/
public class queueViaStacks {
    Stack<Integer> pushStack = new Stack<Integer>();
    Stack<Integer> revStack = new Stack<Integer>();

    void enqueue(int value){ // add to queue
        pushStack.push(value);
    }

    int dequeue(){ // remove from queue and return removed element returns -1 if stack is empty
        if(pushStack.isEmpty()){
            return -1;
        }
        while(pushStack.size() > 1){
            revStack.push(pushStack.pop());
        }
        int val = pushStack.pop();
        while(!revStack.isEmpty()){
            pushStack.push(revStack.pop());
        }
        return val;
    }

    void printQueue(){
        while(!pushStack.isEmpty()){
            revStack.push(pushStack.pop());
        }
        System.out.println(revStack);
        while(!revStack.isEmpty()){
            pushStack.push(revStack.pop());
        }
    }
    public static void main (String [] args){
        //test case 1 push 123 pop 1 
        queueViaStacks test = new queueViaStacks();
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.printQueue();
        test.dequeue();
        test.printQueue();
        test.enqueue(1);
        test.printQueue();
    }
}