import java.util.*;
/*
 Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack). 

arraylist of stacks?
    a simple stack we need to manage the "glue" inbetween stacks
    - when we push and a stack is full
    - when we pop and a stack is 
push
<> <> <> <>

pop

*/
public class stackOfPlates {
    int capacity;
    ArrayList<Stack<Integer>> tray = new ArrayList<Stack<Integer>>();
    int level = 0;
    stackOfPlates(int cap){
        capacity = cap;
    }
    void push(int value){
        System.out.println(tray.size());
        if(tray.size() == 0 || tray.get(level).size() == 0){
            Stack<Integer> temp = new Stack<Integer>();
            temp.push(value);
            tray.add(temp);
        }
        else if(tray.get(level).size() < capacity){
             tray.get(level).push(value);
        }
        else if(tray.get(level).size() >= capacity){
            Stack<Integer> temp = new Stack<Integer>();
            level++;
            temp.push(value);
            tray.add(temp);
        }
    }
    void pop(){
        if(tray.get(level).size() == 0){
            //tray.remove(level);
            level--;
            tray.get(level).pop();
        }else{
            tray.get(level).pop();
        }
    }

    void peek(){
        System.out.println(tray.get(level).peek());
    }
    void printList(){
        for(int i = 0; i < tray.size(); i++){
            System.out.print(Arrays.toString(tray.get(i).toArray()));
        }
    }

    public static void main (String [] args){
        stackOfPlates test = new stackOfPlates(2);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(5);
        test.pop();
        test.pop();
        test.printList();
    }
}