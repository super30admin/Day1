// Time Complexity :
// Space Complexity :
// Time Complexity :O(1)
// Space Complexity :O(n + k) n isthe number of keys and k is the buckets


// Your code here along with comments explaining your approach


class ListNode{
    int key;
    ListNode next;
    
    public ListNode(int key){
        this.key = key;
        this.next = null;
    }
}


class MyHashSet {

    private ListNode [] hashset;
    private static final int SIZE = 10000;
    
    public MyHashSet() {
        hashset = new ListNode[SIZE];
        for (int i = 0; i < SIZE; i++){
            hashset[i] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        int index = key % SIZE;
        ListNode curr = hashset[index];
        
        while (curr.next != null){
            if (curr.next.key == key){
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key);
    }
    
    public void remove(int key) {
        int index = key % SIZE;
        ListNode curr = hashset[index];
        
        while (curr.next != null){
            if (curr.next.key == key){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
            
        }
        
    }
    
    public boolean contains(int key) {
        int index = key % SIZE;
        ListNode curr = hashset[index];
        
        while (curr.next != null){
            if (curr.next.key == key){
                return true;
            }
            curr = curr.next;
            
        }
        return false;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



class MyHashSet {

    private boolean [][] cap;
    private int buckets;
    private int bucketitems;
    
    
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketitems = 1000;
        this.cap = new boolean[buckets][];
    }
    
    public int bucket(int key){
        return key%buckets;
    }
    
    public int bucketItems(int key){
        return key/bucketitems;
    }
    
    public void add(int key) {
        int index = bucket(key);
        if (cap[index] == null){
            if(index==0){
                cap[index] = new boolean[bucketitems+1];
            }else{
                cap[index] = new boolean[bucketitems];
            }
        }
        cap[index][bucketItems(key)] = true;
    }
    
    public void remove(int key) {
        int index = bucket(key);
        int nextIndex = bucketItems(key);
        if (cap[index] == null) return;
        cap[index][nextIndex] = false;
    }
    
    public boolean contains(int key) {
        int index = bucket(key);
        int nextIndex = bucketItems(key);
        if (cap[index] == null) return false;
        
        return cap[index][nextIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */