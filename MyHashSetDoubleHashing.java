// Time Complexity : add, remove, contains : O(1)
// Space Complexity : O(n) where n is total number of ele in our case 10^6
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Redone post class
public class MyHashSetDoubleHashing {
    int capacity;
    public static final int INITIAL_CAPACITY =1000;
    Boolean [][] hashTable;
    public MyHashSetDoubleHashing() {
        this.capacity = INITIAL_CAPACITY;
        hashTable = new Boolean[this.capacity][];
    }
    /*
    Primary hash function
    @param : key
    @return fist array's index
     */
    public int primaryHashFunction(int key){
        return key%this.capacity;
    }
    /*
    Secondary hash function
    @param : key
    @return second array's index
     */
    public int secondaryHashFunction(int key){
        return key/(this.capacity+1);
    }
    /*
    Get index of primary array
    Get index of secondary array
    See if secondary array not initalized, then initialize it
    set val to true on adding
      @param: key
    @return: none
     */
    public void add(int key) {
        int bucket = primaryHashFunction(key);
        int bucketTwo = secondaryHashFunction(key);
        if(hashTable[bucket]==null){
            hashTable[bucket] = new Boolean[this.capacity];
        }
        hashTable[bucket][bucketTwo]=true;
    }
    /*
    Get index of primary array
    Get index of secondary array
    See if secondary array is initalized, can you go to secondary arrays index and set it to false
    @param: key
    @return: none
     */
    public void remove(int key) {
        int bucket = primaryHashFunction(key);
        int bucketTwo = secondaryHashFunction(key);
        if(hashTable[bucket]!=null){
            hashTable[bucket][bucketTwo]=false;
        }
    }
    /*
       Get index of primary array
        Get index of secondary array
        If primary array exisits and its secondary array exists return whatever value is there if not return false
     */
    public boolean contains(int key) {
        int bucket = primaryHashFunction(key);
        int bucketTwo = secondaryHashFunction(key);
        if(hashTable[bucket]!=null && hashTable[bucket][bucketTwo]!=null){
            return hashTable[bucket][bucketTwo];
        }
        return false;
    }
    public static void main(String[] args) {
        MyHashSetDoubleHashing hashSet = new MyHashSetDoubleHashing();
        System.out.println("Adding 1000000");
        hashSet.add(1000000);
        System.out.println("Adding 2");
        hashSet.add(2);
        System.out.println("Adding 3");
        hashSet.add(3);
        System.out.println("Contains 1000000 status:");
        System.out.println(hashSet.contains(1000000));
        System.out.println("Contains 2 status:");
        System.out.println(hashSet.contains(2));
        System.out.println("Contains 3 status:");
        System.out.println(hashSet.contains(3));
        System.out.println("Remove 3:");
        hashSet.remove(3);
        System.out.println("Contains 3 status:");
        System.out.println(hashSet.contains(3));
        System.out.println("Remove 2:");
        hashSet.remove(2);
        System.out.println("Contains 2 status:");
        System.out.println(hashSet.contains(2));
        System.out.println("Remove 1000000:");
        hashSet.remove(1);
        System.out.println("Contains 1 status:");
        System.out.println(hashSet.contains(1));
    }
}
