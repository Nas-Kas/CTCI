
/*
Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input:
Output:
3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8 


nodes less than x come before nodes greater than or equal to x
if x in list put the values of x in "middle" but can appear anywhere in the right partition

form a less than list and a greater than or equal to list then merge them and return the head

3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
                               *
lt5 (x) -> 3-> 2 -> 1

gto=5 (x) -> 5 -> 8 -> 5 -> 10

new list 3->2->1->5->8->5->10
*/
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}


public class Partition {
    // Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
    // Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8 
    public static Node partitionList(Node head, int partition){
        Node d1 = new Node(-1);
        Node d1runner = d1;
        Node d2 = new Node(-1);
        Node d2runner = d2;
        while(head != null){
            Node temp = new Node(head.val);
            if(head.val >= partition){
                d1runner.next = temp;
                d1runner = d1runner.next;
            }else{
                d2runner.next = temp;
                d2runner = d2runner.next;
            }
            head = head.next;
        }
        d2runner.next = d1.next;
        return d2.next;
    }

    public static Node buildList(int [] nodes){
        Node head = new Node(nodes[0]);
        Node runner = head;
        for(int i = 1; i < nodes.length; i++){
            Node temp = new Node(nodes[i]);
            runner.next = temp;
            runner = runner.next;
        }
        return head;
    }

    public static void printL(Node head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main (String [] args){
        int [] test = new int []{3,5,8,5,10,2,1};
        Node head = buildList(test);
        Node res = partitionList(head, 5);
        printL(res);
    }
}