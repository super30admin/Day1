// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
implemented the code by creating primarybuckets and then creating secondary buckets if needed
 */
class MyHashSet {
    int primarybucket;
    int secondarybucket;
    boolean[][] storage;

    public MyHashSet() {
        this.primarybucket = 1000;
        this.secondarybucket = 1001;
        this.storage = new boolean[primarybucket][];
    }

    private int getprimaryhash(int key)
    {
        return key % primarybucket;
    }

    private int getsecondaryhash(int key)
    {
        return key / secondarybucket;
    }
    
    public void add(int key) {
        int primaryhash = getprimaryhash(key);
        if(storage[primaryhash] == null)
        {
            storage[primaryhash] = new boolean[secondarybucket];
        }
        int secondaryhash = getsecondaryhash(key);
        storage[primaryhash][secondaryhash] = true;
    }
    
    public void remove(int key) {
        int primaryhash = getprimaryhash(key);
        if(storage[primaryhash] == null)
        {
            return;
        }
        int secondaryhash = getsecondaryhash(key);
        storage[primaryhash][secondaryhash] = false;
    }
    
    public boolean contains(int key) {
        int primaryhash = getprimaryhash(key);
        if(storage[primaryhash] == null)
        {
            return false;
        }
        int secondaryhash = getsecondaryhash(key);
        return storage[primaryhash][secondaryhash];
    }
}

