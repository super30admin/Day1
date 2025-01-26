
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet {
    
    private boolean[][] storage;
    //primary array size
    private int buckets;
    //secondary array size
    private int bucketitems;
    
    //logic for first hash function
    private int hash1(int key){
        return key%buckets;
    }
    
    //logic for second hash function
    private int hash2(int key){
        return key/bucketitems;
    }

    //constructor to initialise bucket size, and 2D array. Since the range of values is from 0-10^6, we assign buckets size as sqrt(10^6)=1000
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketitems=1000;
        //initiate primary array of nulls
        this.storage =new boolean[buckets][];
    }
    
    //Find the index in primary array using hash1 method. If the secondary array is not initialised at the index then 
    // initialise the array. Find the index in secondary array using hash2 function. Mark that index as true.
    public void add(int key) {
        int bucket=hash1(key);
        if(storage[bucket]==null){
            if(bucket==0){
                //in 0th index we have 1 extra collsion as 1million is included.
                storage[bucket]=new boolean[bucketitems+1];
            }else{
                storage[bucket]=new boolean[bucketitems];
            }
        }
        int bucketinside = hash2(key);
        storage[bucket][bucketinside]=true;
    }
    
    // Find the first index. If there is no array on that index then the key is not present, else find the second index.
    // Mark this location as false.
    public void remove(int key) {
        int bucket=hash1(key);
        if(storage[bucket]==null){
            return;
        }else{
            int bucketitem=hash2(key);
            storage[bucket][bucketitem]=false;
        }
    }
    
    // Find the first index. If there is no array on that index then the key is not present so return false, else find the second index.
    // Return the boolean value present at that location.
    public boolean contains(int key) {
        int bucket=hash1(key);
        if(storage[bucket]==null){
            return false;
        }else{
            int bucketitem=hash2(key);
            return storage[bucket][bucketitem];
        }
    }
    
 // Driver code 
    public static void main(String[] args) 
    { 
	//  MyHashSet object will be instantiated and called as such:
	    MyHashSet obj = new MyHashSet();
	    obj.add(1);
	    obj.remove(1);
	    boolean param_3 = obj.contains(1);
	    System.out.print(param_3);
    } 
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */