/*
: Describe how you could use a single array to implement three stacks. 
- store each stack as a partition in the array
- if the stack goes over capacity resize the array or return an error

*/
import java.util.*;

class TriStack{
    int p1 = 0;
    int p2 = 0;
    int p3 = 0;
    Integer partSize;
    Integer [] arr;
    public TriStack(int partitionSize){ // initialize stack and move the head pointers
        arr = new Integer [partitionSize * 3];
        p1 = 0;
        p2 = partitionSize;
        p3 = partitionSize*2;
        partSize = partitionSize;
    }

    int pop(int part){ // will pop from partiton and return popped value 1 means p1 2 means p2 etc.
        int val = -1;
        switch(part){
            case 1:
                if(p1 < 0){
                    return -1;
                }else{
                    val = arr[p1];
                    arr[p1] = null;
                    p1--;
                } 
            case 2:
                if(p2 <= partSize){
                    return -1;
                }else{
                    val = arr[p2];
                    arr[p2] = null;
                    p2--;
                }
            case 3:
                if(p3 <= partSize*2){
                    return -1;
                }else{
                    val = arr[p3];
                    arr[p3] = null;
                    p3--;
                }
            default:
                return val;
        }
        return val;
    }

    int push(int value, int part){ // currently if push would exceed partition we dont add to stack
        switch(part){
            case 1:
                if(p1 >= partSize){
                    return -1;
                }else{
                    arr[p1] = value;
                    p1++;
                    return value;
                }
            case 2:
                if(p2 >= partSize*2){
                    return -1;
                }else{
                    arr[p2] = value;
                    p2++;
                    return value;
                }
            case 3:
                if(p3 >= arr.length){
                    return -1;
                }else{
                    arr[p3] = value;
                    p3++;
                    return value;
                }
            
            default:
                return -1;
        }
        return -1; 
    }

    int peek(int part){
        switch(part){
            case 1:
                if(arr[p1] == null){
                    return -1;
                }else{
                    return arr[p1];
                }
            case 2:
                return arr[p2];
            case 3:
                return arr[p3];
            default:
                return -1;
        }
    }

    boolean isEmpty(int part){
        switch(part){
            case 1:
                if(p1 == 0){
                    return true;
                }
            case 2:
                if(p2 == partSize){
                    return true;
                }
            case 3:
                if(p3 == partSize*2){
                    return true;
                }
            default:
                return false;
        }
    }

    public void resize(){ // implement if one stack gets too large resize the array or

    }
    public static void main (String [] args){
        TriStack test = new TriStack(3);
        System.out.println(test.isEmpty(1)); // return true
        System.out.println(test.peek(1)); // return null
        System.out.println(test.isEmpty(2)); // return true
        System.out.println(test.peek(2)); // return null
        System.out.println(test.isEmpty(2)); // return true
        System.out.println(test.peek(2)); // return null
        test.push(5,1);
        test.push(5,1);
        test.push(5,1);
        test.push(5,1);      
        test.push(6,2);
        test.push(6,2);
        test.push(6,2);
        test.push(7,3);
        test.push(7,3);
        test.push(7,3);
        System.out.println(test.isEmpty(1)); // return false
        System.out.println(test.peek(1)); // return 5
        System.out.println(test.isEmpty(1)); // return false
        System.out.println(test.peek(1)); // return 6
        System.out.println(test.isEmpty(1)); // return false
        System.out.println(test.peek(1)); // return 7
        //test.push(5,2);
        //test.push(5,3);
        System.out.println(Arrays.toString(test.arr));
    }
}