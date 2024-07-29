// Design Hashset to store elements from 0 to 1000000
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    private boolean[][] arr;
    private int count;
    public MyHashSet() {
        this.arr = new boolean [1000][];
        this.count = 0;
    }
    
    public void add(int key) {
        int hash = key%1000;
        int collisionHash = key/1000;
        if(arr[hash] == null) {
            if(hash == 0){
                arr[hash] = new boolean[1001];
            } else {
                arr[hash] = new boolean[1000]; 
            }
        }
        arr[hash][collisionHash] = true;
        count++;
    }
    
    public void remove(int key) {
        int hash = key%1000;
        int collisionHash = key/1000;
        if(arr[hash] != null) {
            arr[hash][collisionHash] = false;
            count--;
        }
    }
    
    public boolean contains(int key) {
        int hash = key%1000;
        int collisionHash = key/1000;
        if(arr[hash]!=null)
            return arr[hash][collisionHash];
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
