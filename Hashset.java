// Your code here along with comments explaining your approach
class MyHashSet {
    // Time Complexity: o(1)
    // Space Complexity: o(1)
    // To prevent collisons adopting double hashing technique
    int primaryBuckets;
    int secondaryBuckets; 
    boolean[][] storage;

    public MyHashSet() {
      this.primaryBuckets = 1000; 
      this.secondaryBuckets = 1000;
      this.storage = new boolean[primaryBuckets][]; // 10^6 => 1000 of 2 bytes each
    }

    public int getFirstHash(int key){
        return key % primaryBuckets;
    }

    public int getSecondHash(int key){
        return key / secondaryBuckets;
    }
    
    public void add(int key) {
       int firstHashIndex = getFirstHash(key);
       if (storage[firstHashIndex] == null){
            if(firstHashIndex == 0){
                storage[firstHashIndex] = new boolean [secondaryBuckets+1];
            } else{
                storage[firstHashIndex] = new boolean [secondaryBuckets];
            }
       }
       int secondHashIndex = getSecondHash(key);
       storage[firstHashIndex][secondHashIndex] = true; 
    }
    
    public void remove(int key) {
        int firstHashIndex = getFirstHash(key);
        if (storage[firstHashIndex]==null){
            return;
        }
        int secondHashIndex = getSecondHash(key);
        storage[firstHashIndex][secondHashIndex]= false;
    }
    
    public boolean contains(int key) {
        int firstHashIndex = getFirstHash(key);
        if (storage[firstHashIndex]==null){
            return false;
        }
        int secondHashIndex = getSecondHash(key);
        if(storage[firstHashIndex][secondHashIndex]){
            return true;
        } else{
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

