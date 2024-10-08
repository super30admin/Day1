// Time Complexity : 0(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {
    private int buckets;
    private Node[] storage;
    
    class Node {
        int key;
        int value;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }
    
    private int getHash(int key) {
        return key % buckets;
    }
    
    private Node getPrev(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        
        if (storage[hash] == null) {
            storage[hash] = new Node(-1, -1); // dummy head
        }
        
        Node prev = getPrev(storage[hash], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int hash = getHash(key);
        
        if (storage[hash] == null) {
            return -1;
        }
        
        Node prev = getPrev(storage[hash], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        
        if (storage[hash] == null) {
            return;
        }
        
        Node prev = getPrev(storage[hash], key);
        if (prev.next == null) {
            return;
        }
        
        prev.next = prev.next.next;
    }
}