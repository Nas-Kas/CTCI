import java.util.*;

class Node{
    int value;
    int key;
    Node next;
    Node prev;
}

public class LRUCache2 {
    Node head = new Node();
    Node tail = new Node();
    int cacheSize;
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();  
    
    public LRUCache2(int capacity) {
        this.cacheSize = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node temp = map.get(key);
        if(temp != null){
            remove(temp);
            addHead(temp);
            return temp.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {// adds or overwrites a node
        System.out.println("put");
        Node temp = map.get(key);
        if(temp != null){
            temp.value = value;
            remove(temp);
            addHead(temp);
        }else{
            if(map.size() >= cacheSize){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            
            Node new_node = new Node();
            new_node.key = key;
            new_node.value = value;
            addHead(new_node);
            map.put(key,new_node);
        }
    }
    
    public void addHead(Node node){
        Node next_node = head.next;
        head.next = node;
        node.next = next_node;
        next_node.prev = node;
        node.prev = head;
    }
    
    public void remove(Node node){
        Node next_node = node.next;
        Node prev_node = node.prev;
        
        //next_node.prev = prev_node;
        //prev_node.next = next_node;
        prev_node.next = next_node;
        next_node.prev = prev_node;
    }
}

