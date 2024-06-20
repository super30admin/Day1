// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashSet {
        private boolean[][] storage;
        private int buckets = 1000;
        private int bucketItems = 1000;
    public MyHashSet() {
        storage = new boolean[buckets][];
    }

    private int bucket(int key){
        return key%buckets;
    }

    private int bucketItem(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            if(bucket==0){
                storage[bucket] = new boolean[bucketItems + 1];
            } else{
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }   
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return;
        else {
            storage[bucket][bucketItem] = false;
        }
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null) return false;
        else return (storage[bucket][bucketItem] == true);
    }

      public static void main(String args[]){
         MyHashSet obj = new MyHashSet();
        obj.add(3);
        obj.remove(2);
        boolean param_3 = obj.contains(3);
        System.out.println(param_3);
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */