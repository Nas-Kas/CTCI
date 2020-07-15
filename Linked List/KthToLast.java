
/*

Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
Hints:#8, #25, #41, #67, #126


*/
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

public class KthToLast{
    public static Node kthNode(Node head, int k){
        Node runner = head;
        int count = 0;
        while(count < k){
            count++;
            runner = runner.next;
        }
        Node res = head;
        while(runner != null){
            runner = runner.next;
            res = res.next;
        }
        return res;
    }
    
    
    public static Node buildList(int [] nodes){
        Node head = new Node(nodes[0]);
        Node start = head;
        for(int i = 1; i < nodes.length; i++){
            Node temp = new Node(nodes[i]);
            start.next = temp;
            start = start.next;
        }
        return head;
    }

    public static void printList(Node head){
        while(head != null){
            System.out.print(head.val + "->");
        }
        System.out.println();
    }

    public static void main (String [] args){
        int [] list = new int [] {1,2,3,4,5,6};
        Node head = buildList(list);
        Node res = kthNode(head, 0);
        System.out.println(res.val);
    }
}