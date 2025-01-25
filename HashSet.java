// Time Complexity : add, remove, contains = O(1)
// Space Complexity : O(n * m) where n = buckets, m = bucketItems
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {

    //If element is present then it is true else false
    private boolean[][] storage;
    //size of array
    private int buckets;
    //size of nested array
    private int bucketItems;

    //Hash 1
    public int bucket(int key) {
        //we get location in array
        return key % buckets;
    }

    //Hash 2 :- input will never have same hash1 and hash2 hence no collision
    public int bucketItem(int key) {
        //we get location in nested array
        return key / bucketItems;
    }

    public MyHashSet() {

        //we take square root of 10^6 which is range of inputs
        this.buckets = 1000;
        this.bucketItems = 1000;

        //We do not give nested array size because if there is no element in that index we will not create the nested array thereby saving space
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {

        int location = bucket(key);

        //if the array location is empty we will create nested array and add the element
        if(storage[location] == null) {

            if(location == 0) {

                //We do +1 here because for eg:- if the input is 10^6. The size of array is 1000 which is 0 to 999 and nested array is also 0-999. but if input is 10^6, we wont be able to store the value in nested array as 10^6 / 1000 = 1000. 
                storage[location] = new boolean[bucketItems + 1];

            }else {
                storage[location] = new boolean[bucketItems];
            }
        }

        //location in the nested array
        int nesLocation = bucketItem(key);
        storage[location][nesLocation] = true;
    }
    
    public void remove(int key) {

        int location = bucket(key);

        //It means this element is not present in hash set
        if(storage[location] == null)
            return;
        
        //If it is present we will find the exact location in nested array
        int nesLocation = bucketItem(key);

        //If there was an element in the index it would be true
        storage[location][nesLocation] = false;

    }
    
    public boolean contains(int key) {
        
        int location = bucket(key);

        //It means this element is not present in hash set
        if(storage[location] == null)
            return false;
        
        //Find the exact location of key
        int nesLocation = bucketItem(key);

        //If there is an element it is true else false
        return storage[location][nesLocation];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
