/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

*/

import java.util.*;

public class LRUCache {
    int cap;
    int val;
    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<Integer,Integer>();
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key,val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
        }else if(cache.size() == cap){
            int temp = 0;
            for(int i: cache.keySet()){
                temp = i;
                break;
            } 
            cache.remove(temp);
        }
        cache.put(key,value);
    }
    public static void main (String [] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.print(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
/*
test
["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

expected
[null,null,null,1,null,-1,null,-1,3,4]
*/


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */