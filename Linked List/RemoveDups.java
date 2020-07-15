import java.util.*;

/*
Remove Dups! Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed? 
set [1,2,3]
1->2->3->2->3
      *        *
1->2->3->null
*/

class Node{
    Node next;
    int val;
    Node(int val){
        this.val = val;
    }
}

public class RemoveDups {
    public static Node removeDuplicates(Node head){
        HashSet<Integer> seenNodes = new HashSet<Integer>();
        Node start = head;
        seenNodes.add(start.val);
        while(start != null){
            if(start.next != null && seenNodes.contains(start.next.val)){
                start.next = start.next.next;
            }
            else{
                if(start.next != null){
                    seenNodes.add(start.next.val);
                }
                start = start.next;
            }
        }
        return head;
    }

    public static void printList(Node head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static Node buildList(int [] nodevals){
        Node head = new Node(nodevals[0]);
        Node start = head;
        for(int i = 1; i < nodevals.length; i++){
            Node temp = new Node(nodevals[i]);
            start.next = temp;
            start = start.next;
        }
        return head;
    }
    public static void main (String [] args){
        //int [] list = new int []{1,2,3,4,5,6};
        //int [] list2 = new int []{1,2,3,2,3};
        int [] list3 = new int []{1,1,1,1,1,6,6,6,6,2,3,1,2,3,5,6,4,1,2,3,65,3,4,71,123,5,6,1,1,1,0,8,8};
        Node head = buildList(list3);
        removeDuplicates(head);
        printList(head);
    }
}