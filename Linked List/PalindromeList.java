/*
Palindrome: Implement a function to check if a linked list is a palindrome. 
palindrome - is the same forward as backwards
example anna, madam, 

send one pointer to the middle of the list
traverse from middle and start of list
if the character is off by one return false
otherwise return true
'

racecar
*  *

race
*
notes: remember how to find midpoint the while loop must check if fast is null and fast's next is null
- know how to rev a list (pretty easy)
- write this problem out the wording can be deceptively tricky
*/

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
public class PalindromeList {
    public static boolean isPalindrome(Node head){
        Node fast = head;
        Node mid = head;
        while(fast != null && fast.next != null){
            mid = mid.next;
            fast = fast.next;
            fast = fast.next;
        }
        Node l2 = revList(mid);
        while(l2 != null){
            if(l2.val != head.val){
                return false;
            }
            head = head.next;
            l2 = l2.next;
        }
        return true;
    }
    public static Node revList(Node head){
        Node curr = head;
        Node prev = null;
        Node nex = curr.next;
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

    public static void main (String []args){
        int [] l1 = new int [] {1,2,1,2,1};
        Node head = buildList(l1);
        System.out.println(isPalindrome(head));

    }
}