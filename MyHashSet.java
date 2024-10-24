/*
Time Complexity : Time Complexity for user oriented functions add, remove and contains function, we will be having O(1), as we are directly
accessing the position or index by using hashing function but not using any hashing based data structures.

Space Complexity : Space complexity for user oriented functions - add, remove and contains is still O(1) as it is a direct access, and we are
not using any extra data structures for operations. The space created in constructor is not accounted in Design Problems. For constructor,
the space complexity will be O(n).

Did this code successfully run on Leetcode : Yes

 Explanation:

    Design a HashSet without using any built-in hash table libraries.

    HashSet has Unique Values and internally uses HashMap for implementation. The default size of this array of buckets in HashMap
    is typically 16. In the LeetCode Question, constraint mentioned is 0 <= key <= 10^6, meaning we have can maximum array size of 10^6.
    Even though we have multiple collision techniques such as Linear Probing, Quadratic Probing, BST chaining, Linear Chaining.
    Here we will be using Double Hashing technique. In this technique, we have two arrays, one will be the primary array and other will
    secondary array.

    The secondary constraint in this question is "At most 10^4 calls will be made to add, remove, and contains." So this means, if
    we divide the data say 10^6 in to two parts, say 1000 for primary array and 1000 for secondary array. We will have almost 1000 calls
    for the operations mentioned above. The keypoint to note is while implementing the problem, though this primary and secondary array
    acts as a 2D matrix, we won't be creating a secondary array initially. Only a primary array initialized to "null" is created. Once
    we try to insert an element in primary array, a secondary array is created provided it doesn't exist and the null in primary array
    will be pointing to the secondary array. Dividing the space between these two array and not creating both the array initially saves
    space. Also, if we create both arrays at the same time, it is like creating a 1 huge 10^6 array which is the initial thing we wanted
    to avoid creating as it will occupy more memory.

    IMP: To Avoid Array Out of Bounds Exception, depends on which hashing function you use % or / , thing to remember is say we have an array
    of size 1000, which is 0 to 999, if we do a "%" 10^6 % 1000 = 0, which is 0th bucket. After that when we do "division", 10^3/1000 = 1000.
    Now, we don't have an index of 1000, in the array as the last index is 999, so to avoid this issue, IF THE MODULUS IS FIRST HASH FUNCTION
    FOR PRIMARY BUCKET, THE SECONDARY BUCKET SIZE SHOULD BE INCREASED BY 1 OR IF THE / IS THE FIRST HASH FUNCTION, THEN IT WILL TRY TO REACH 1000TH
    INDEX IN PRIMARY BUCKET SO  PRIMARY BUCKET SIZE SHOULD BE INCREASED BY 1

    In the question it is expecting us to implement Hash Set methods by not using built in hash tables libraries

    void add(key) Inserts the value key into the HashSet.
    bool contains(key) Returns whether the value key exists in the HashSet or not.
    void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

    Here the approach will be:
    We will be having boolean arrays, the reason is we don't need values to be of any use. We are not iterating over the values and the
    operations expected in the question, can be managed with boolean so we don't use an integer array. For Information only, if in case we
    plan to use integer array, and put the values in secondary bucket/array, we have the initial values initialized as -1 in secondary array.

    Imp: [][] => a data structure and data structure, will always be a pointer, so primary array will not have boolean values, it will have
    null values if the secondary array doesn't exist and not false/

    For Add, we will be checking if the primary array has a null pointer or not null, if it is null create a new array which will be the
    secondary array and then based on value returned by second hashing function, we will assign the index as true. If it is not null, we
    will be using the second hashing function to determine the index in the existing secondary array and make it true.

    For Contains and Remove, first thing is we need to search for the element if it even exists, to check that we will be using the same
    hash function we used for adding, if the secondary array has true in place of index we found while hashing, then the element in present.
    But if the primary array has null or the secondary array has false, the element is not present.
    For remove, once element is found, we can change the value to false in the index of secondary array, the isPresent check will be same as
    contains.
     */
public class MyHashSet {

    int primaryArraySize;
    int secondaryArraySize;
    boolean[][] storage;

    public MyHashSet() {
        this.primaryArraySize = 1001;
        this.secondaryArraySize = 1000;
        this.storage = new boolean[primaryArraySize][]; //1000*2 is current size, so not adding the secondary array now as then more size
        // will be allocated now
    }

    private int getPrimaryHashValue(int key) {
        //10^6 / 1000 = 1000 {So we have taken primaryArraySize as 1001}
        return key / primaryArraySize;
    }

    private int getSecondaryHashValue(int key) {
        //1000 % 1000 = 0
        return key % secondaryArraySize;
    }

    public void add(int key) {
        int primaryArrayIndex = getPrimaryHashValue(key);

        if (storage[primaryArrayIndex] == null) {
            this.storage[primaryArrayIndex] = new boolean[secondaryArraySize];
        }

        int secondaryArrayIndex = getSecondaryHashValue(key);
        storage[primaryArrayIndex][secondaryArrayIndex] = true;

    }

    public void remove(int key) {
        int primaryArrayIndex = getPrimaryHashValue(key);

        if (storage[primaryArrayIndex] == null) {
            return; //nothing to remove as value doesn't exist
        }

        int secondaryArrayIndex = getSecondaryHashValue(key);
        storage[primaryArrayIndex][secondaryArrayIndex] = false;
    }

    public boolean contains(int key) {
        int primaryArrayIndex = getPrimaryHashValue(key);

        if (storage[primaryArrayIndex] == null) {
            return false; //value doesn't exist
        }

        int secondaryArrayIndex = getSecondaryHashValue(key);
        return storage[primaryArrayIndex][secondaryArrayIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
