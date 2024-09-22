// Time Complexity :  Average Case---> O(1). But in worst case scenario it is O(n)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {
        this.primaryBuckets=1000;
        this.secondaryBuckets=1000;
        this.storage= new boolean[primaryBuckets][];

        
    }
    
    private int getprimaryHash(int key){
        return key % primaryBuckets;
    }

    private int getsecondaryHash(int key){
        return key / secondaryBuckets;
    }


    public void add(int key) {
        int primaryHash=getprimaryHash(key);
        if(storage[primaryHash]==null){
            if(primaryHash==0){
                storage[primaryHash]=new boolean[secondaryBuckets+1];
            }else{
                storage[primaryHash]=new boolean[secondaryBuckets];
            }
        }
        int secondaryHash=getsecondaryHash(key);
        storage[primaryHash][secondaryHash]= true;


    }
    
    public void remove(int key) {
        int primaryHash=getprimaryHash(key);
        if(storage[primaryHash]==null) return;
        int secondaryHash=getsecondaryHash(key);
        storage[primaryHash][secondaryHash]= false;
        
    }
    
    public boolean contains(int key) {
        int primaryHash=getprimaryHash(key);
        if(storage[primaryHash]==null) return false;
        int secondaryHash=getsecondaryHash(key);
        return storage[primaryHash][secondaryHash];
    }
}

