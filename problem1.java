// Time Complexity :
    // add() -> O(1)
    // remove() -> O(1)
    // contains() -> O(1)

// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Linear chaining collision handling approach

class Node {
    int val;
    Node next;

    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}

class MyHashSet {

    Node [] primary_arr;

    public MyHashSet() {
        this.primary_arr = new Node[10000];
    }

    private int hash(int key){
        return key % 10000;
    }

    private Node search(Node head, int key){
        // returns the node previous to the node containing the key
        Node prev = head, cur = head.next;

        while (cur != null && cur.val != key){
            prev = cur;
            cur = cur.next;
        }

        return prev;
    }
    
    public void add(int key) {
        int index = hash(key);
        if(primary_arr[index] == null){
            primary_arr[index] = new Node(-1, null);
        }

        Node prev = search(primary_arr[index], key);
        if(prev.next == null){
            // key doesn't exist -> create a new node and add to chain
            Node new_node = new Node(key, null);
            prev.next = new_node;
            return;
        }
        // key exists -> update the value
        prev.next.val = key;
        return;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(primary_arr[index] == null){
            return;
        }

        Node prev = search(primary_arr[index], key);
        if(prev.next == null){
            // key doesn't exist -> do nothing
            return;
        }

        // key exists -> remove from chain
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
        return;
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        if(primary_arr[index] == null){
            return false;
        }
        Node prev = search(primary_arr[index],key);
        if(prev.next == null){
            // key doesn't exist
            return false;
        }
        // key exists
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */