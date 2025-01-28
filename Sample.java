// Time Complexity :o(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//I have designed this hashset using an array of boolean arrays as my underlying datastructure. 
//I have followed double hashing technique for avoiding collision and used %N, /N as the 2 hash functions. 
//the first hashfunction will return the baseIndex and the second hashfunction will return the subIndex of the elements of the hashset

// Your code here along with comments explaining your approach
class MyHashSet {
    int max = 1000000; // max element in the provided range
    boolean[][] myHashSet; // base datastructure
    int baseArraySize = (int) Math.ceil(Math.sqrt(max + 1));

    public MyHashSet() {
        myHashSet = new boolean[baseArraySize][];// initialised with a jaggedArray that has a base length of
                                                 // baseArraySize
    }

    /*
     * checks for the existence of the subArray at the baseIndex and if it exists
     * then updates the value at the subIndex to be true
     * if not exists then initialises a sub array at the baseIndex and updates the
     * value to true
     * 
     * @param key a value that needs to be added
     *
     */
    public void add(int key) {
        int baseArrayLocation = getKey1(key);
        if (myHashSet[baseArrayLocation] != null) {
            myHashSet[baseArrayLocation][getKey2(key)] = true;
        } else {
            myHashSet[baseArrayLocation] = new boolean[baseArraySize];
            myHashSet[baseArrayLocation][getKey2(key)] = true;
        }
    }

    /*
     * checks for the existence of the subArray at the baseIndex and if it exists
     * then updates the value at the subIndex to be false
     * 
     * 
     * @param key a value that needs to be removed
     *
     */

    public void remove(int key) {
        int baseLocation = getKey1(key);
        if (myHashSet[baseLocation] != null) {
            myHashSet[baseLocation][getKey2(key)] = false;
        }
    }

    /*
     * checks for the existence of the key in the hashset and return a boolean
     * accordingly
     * 
     * @param key a value that needs to be searched
     *
     */
    public boolean contains(int key) {
        int baseLocation = getKey1(key);
        if (myHashSet[baseLocation] != null) {
            return myHashSet[baseLocation][getKey2(key)];
        }
        return false;
    }

    /*
     * returns the baseIndex of the array where the key is stored or going to be
     * stored
     * 
     * @param key a value that is going to be stored or that needs to be searched
     */
    public int getKey1(int key) {
        return key % baseArraySize;
    }

    /*
     * returns the subIndex/secondaryIndex of the array where the key is stored or
     * going to be stored
     * 
     * @param key a value that is going to be stored or that needs to be searched
     *
     */
    public int getKey2(int key) {
        return key / baseArraySize;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// Time Complexity: O(1)
// Did this code successfully run on Leetcode : yes
/*
 * This solution for minstack uses 2 stacks one for storing numbers and the
 * other for storing min value during each operation.
 * Everytime a number comes, we push the number to number stack and check if it
 * lessthan the min value at that point if it a less than current min value,
 * push this new min into minStack so that the top of minstack will always be
 * the min value till that point.
 */

class MinStack {
    Stack<Integer> ns;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        ns = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    /*
     * pushes the val into the number stack and also into minStack when the val is
     * less than the current min
     * 
     * @param val a number that needs to be pushed
     *
     */
    public void push(int val) {
        ns.push(val);
        if (val < min) {
            min = val;
        }
        minStack.push(min);
    }

    /*
     *
     * pops the stack top and updates the current min value with the top value from
     * the minstack
     * 
     */
    public void pop() {
        int popped = ns.pop();
        minStack.pop();
        min = minStack.peek();
    }

    /*
     * retuns the top of the number stack
     */
    public int top() {
        return ns.peek();
    }

    /*
     * retuns the top of the min stack
     */
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */