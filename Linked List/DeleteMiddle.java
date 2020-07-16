/*
Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
lnput:the node c from the linked lista->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a->b->d->e->f 

*/

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}


public class DeleteMiddle{
    public static void deleteNode(Node head, Node curr, int data){ // head is in header for testing purposes
        Node nex = curr.next;
        while(nex.next != null){
            curr.val = nex.val;
            curr = curr.next;
            nex = nex.next;
        }
        curr.val = nex.val;
        curr.next = null;
        print(head);
    }

    public static void print(Node head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static Node returnCurr(Node head, int data){
        while(head.val != data){
            head = head.next;
        }
        return head;
    }

    public static Node buildList(int [] nodes){
        Node head = new Node(nodes[0]);
        Node curr = head;
        for(int i = 1; i < nodes.length; i++){
            Node temp = new Node(nodes[i]);
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }
    public static void main (String []args){
        int [] list = new int []{1,2,3,4,5,6}; // should be 1->2->4->5->6
        Node head = buildList(list);
        Node curr = returnCurr(head,2);
        deleteNode(head,curr,2);
    }

}