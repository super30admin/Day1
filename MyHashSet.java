// Time Complexity : add, remove, contains : O(1) resize : O(n)
// Space Complexity : O(n) where n is capacity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding concept
import java.util.LinkedList;

class MyHashSet {
    public static final int INITIAL_CAPACITY = 10000;
    public static final double LOAD_FACTOR = 0.75;
    LinkedList<Integer>[] hashTable;
    int capacity;
    int size;
    /*
        Constructor that initialize the has table which is a linked list accessed by index. linked list is the bucket.
        It has a capacity which is initially set to 10,000 and then re sized if number if ele = 75% of capacity.
        Size is number of ele in hash table.
     */
    public MyHashSet() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        hashTable = new LinkedList[INITIAL_CAPACITY];
    }
    /*
    Function to determine hash key
    @param : ele to be added
     */
    public int hashingFunction(int key){
        return key%this.capacity;
    }
    /*
    Increase capacity to 2 times its existing capacity.
    Copy hash table into another bigger hashtable
    Add all elements in new hash table.
    @param:None
    @return: None
     */
    public void reSize(){
        this.capacity *= 2;
        LinkedList<Integer> [] oldHashTable = hashTable;
        hashTable = new LinkedList[capacity];
        for(int bucket = 0; bucket<oldHashTable.length; bucket++){
            LinkedList<Integer> bucketList = oldHashTable[bucket];
            if(bucketList!=null){
                for (Integer bucketVal : bucketList) {
                    this.add(bucketVal);
                }
            }
        }
    }
    /*
    If size becomes 75% of capacity then resize
    if not initialize linkedlist if not yet done i.e not same hash key present
    if so check if ele is present, if not present add to linked list
    increment size
    @param: ele to be added
    @return : None
     */
    public void add(int key) {
        if(this.size >= this.capacity * LOAD_FACTOR){
            this.reSize();
        }
        int bucket = hashingFunction(key);
        if(hashTable[bucket]==null){
            hashTable[bucket] = new LinkedList<>();
        }
        LinkedList<Integer> bucketVal = hashTable[bucket];
        if(!bucketVal.contains(key)){
            bucketVal.add(key);
            this.size++;
        }
    }
    /*
        Gets the linked list used hashed key.
        Loops the linkedlist to check if element is present
        if so removes from linked list and decrements size.
        @param: None
        @return: None
     */
    public void remove(int key) {
        int bucket = hashingFunction(key);
        LinkedList<Integer> bucketList = hashTable[bucket];
        if(bucketList!=null){
            for(int i=0;i<bucketList.size();i++){
                if(bucketList.get(i)==key){
                    bucketList.remove(i);
                    this.size--;
                    break;
                }
            }
        }
    }
    /*
    Gets linked list based on hashed key
    if linkedlist is not null i.e it was inserted then searches to see if ele is added.
    If not returns false
     */
    public boolean contains(int key) {
        int bucket = hashingFunction(key);
        LinkedList<Integer> bucketList = hashTable[bucket];
        if(bucketList!=null){
            return bucketList.contains(key);
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        System.out.println("Adding 1");
        hashSet.add(1);
        System.out.println("Adding 2");
        hashSet.add(2);
        System.out.println("Adding 3");
        hashSet.add(3);
        System.out.println("Contains 1 status:");
        System.out.println(hashSet.contains(1));
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
        System.out.println("Remove 1:");
        hashSet.remove(1);
        System.out.println("Contains 1 status:");
        System.out.println(hashSet.contains(1));
    }
}

