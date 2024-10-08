// Time Complexity : 0(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet {
    int primarybucket;
    int secondarybucket;
    boolean[][] storage;
    
    public MyHashSet() {
        this.primarybucket = 1000;
        this.secondarybucket = 1000;
        this.storage = new boolean[primarybucket][];
    }

    private int getprimarybucket(int key)
    {
        return key % primarybucket;
    }
    private int getsecondarybucket(int key)
    {
        return key / secondarybucket;
    }
    
    public void add(int key) {
        int primaryHash = getprimarybucket(key);
        if(storage[primaryHash]==null)
        {
            if(primaryHash == 0)
            {
                storage[primaryHash] = new boolean[secondarybucket+1];
            }
            else
            {              
                  storage[primaryHash] = new boolean[secondarybucket];
            }

        }
        int secondaryHash = getsecondarybucket(key);
        storage[primaryHash][secondaryHash] = true;
    }
    
    public void remove(int key) {
        int primaryHash = getprimarybucket(key);
        if(storage[primaryHash]==null) return;
         int secondaryhash = getsecondarybucket(key);
        storage[primaryHash][secondaryhash] = false;
    }
    
    public boolean contains(int key) {
        int primaryHash = getprimarybucket(key);
        if(storage[primaryHash]==null) return false;
        int secondaryhash = getsecondarybucket(key);
        return storage[primaryHash][secondaryhash];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */