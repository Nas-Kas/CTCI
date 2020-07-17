/*
Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 -> 1 -> 2. That is, 912. 

list 1  6-> 1-> 7
        *
list 2  2-> 9-> 5
        *
        8   0  3  1
list 3 (-1)
         *

if(a + b + r < 10){
    set l3 next to a + b + r
    increment l3
    set r to 0 
}
if(a + b + r > 10){
    set r to 1
    set l3 next = a + b + r - 10
    increment l3
}
increment l1 and l2

at the end if l1 is null 
    -do the addition process for l1
    -set l3 next to l2
else if l2 is null
    -do the addition process for l2
    -set l3next to l1

key point remember to handle all values in both lists before you exit the while loop
make you use (l1 || l2) not (l1 && l2) it makes the problem must easier
*/


class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

public class SumLists {
    //lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
    //Output: 9 -> 1 -> 2. That is, 912. 
    public static Node sumNodes(Node l1, Node l2){
        Node l3 = new Node(-1);
        Node head = l3;
        int r = 0;
        while(l1 != null || l2 != null){
            int curr = 0;
            if(l1 != null){
                curr += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
               curr += l2.val;
               l2 = l2.next;
            }
            if(curr + r >= 10){
                l3.next = new Node(curr + r - 10);
                r = 1;
            }else{
                l3.next = new Node(curr + r);
                r = 0;
            }
            l3 = l3.next;
        }
        if(r == 1){
            l3.next = new Node(1);
        }
        return head.next;
    }

    public static Node buildList(int [] nodes){
        Node head = new Node(nodes[0]);
        Node res = head;
        for(int i = 1; i < nodes.length; i++){
            head.next = new Node(nodes[i]);
            head = head.next;
        }
        return res;
    }

    public static void printL(Node head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverseList(Node head){
        Node curr = head;
        Node prev = null;
        Node nex = head.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = nex;
            if(nex != null){
                nex = nex.next;
            }
        }
        return prev;
    }

    public static void main (String [] args){
        int [] t1 = new int [] {6,1,7};
        int [] t2 = new int [] {2,9,5};
        int [] t3 = new int [] {7,1,6};
        int [] t4 = new int [] {5,9,2};
        Node l1 = buildList(t1);
        Node l2 = buildList(t2);
        Node l3 = buildList(t3);
        Node l4 = buildList(t4);
        Node res = sumNodes(reverseList(l1),reverseList(l2));
        printL(reverseList(res));

    }
}
