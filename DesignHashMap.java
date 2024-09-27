class MyHashMap {
    
    class ListNode{
        int key; int val; ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    private int getIndex(int key){
        return Integer.hashCode(key)%10000;
    }
    
    private ListNode findElement(int key, int index){
        ListNode prev = nodes[index];
        
        if(prev == null) {
            nodes[index] = new ListNode(-1,-1);
            return nodes[index];
        }
        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        
        return prev;
    }
    
    ListNode[] nodes = new ListNode[10000];
    
    /** Initialize your data structure here. */
    public MyHashMap() {}
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findElement(key, index);
        if(prev.next == null) prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(key, index);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(key, index);
        if(prev.next != null) prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
