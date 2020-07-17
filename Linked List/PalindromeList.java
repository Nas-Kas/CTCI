/*
Palindrome: Implement a function to check if a linked list is a palindrome. 
palindrome - is the same forward as backwards
example anna, madam, racear

send one pointer to the middle of the list
traverse from middle and start of list
if the character is off by one return false
otherwise return true
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
        Node headCheck = head;
        while(fast != null){
            mid = mid.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        while(mid != null){
            if(mid.val != headCheck.val){
                return false;
            }
            mid = mid.next;
            headCheck = headCheck.next;
        }
        return true;
    }
}