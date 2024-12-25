// Time Complexity : O(1)
// Space Complexity : Less than O(n) as secondary stack is used to track the minimum.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {

    Stack <Integer> s;
    // Minimum value stack to keep track of minimum value changes.
    Stack <Integer> min_stack;
    int min=0;
    public MinStack() {
        s = new Stack<Integer>();
        min_stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(s.empty() == true) {
            min = val;
            min_stack.push(min);
        }
        else {
            if (min >= val) {
                // If new value is less than min , min is updated and pushed in second stack to keep track of previous all minimum values
                min = val;
                min_stack.push(min);
            }
        }
        s.push(val);
        return;
    }
    
    public void pop() {
        if (s.empty() == true) {
            return;
        }
        if (s.peek() == min) {
            // if min is getting popped it is assigned to value which was minimum prior to current minimum value.
            min_stack.pop();
            if (!min_stack.empty()) {
                min = min_stack.peek();
            }
        }
        s.pop();
        return;
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}


//Time Complexity:0(1)
//Space Complexity:Constant space to store the range of 2d arrays indexes and position in 2d arrays while addition, contains and removal.
// double hashing with modulo and division is needed to avoid collision.
class MyHashSet {
    int primaryIndexes=1000;
    int secondaryIndexes=1000;
    boolean hashArray[][];
    public MyHashSet() {
        hashArray = new boolean[primaryIndexes][];
    }
    

    public int getHash1(int key) {
        return key%1000;
    }

    public int getHash2(int key) {
        return key/1000;
    }

    public void add(int key) {
        int pointer1 = getHash1(key);
        int pointer2 = getHash2(key);
        if(hashArray[pointer1] == null) {
            if (key == 1000000) {
                hashArray[pointer1] = new boolean[secondaryIndexes+1];
            } else {
                hashArray[pointer1] = new boolean[secondaryIndexes];
            }

            hashArray[pointer1][pointer2] = true;
        } else {
            hashArray[pointer1][pointer2] = true;
        }
    }
    
    public void remove(int key) {
        int pointer1 = getHash1(key);
        int pointer2 = getHash2(key);
        if (hashArray[pointer1] != null) {
            hashArray[pointer1][pointer2] = false;
        }

    }
    
    public boolean contains(int key) {
        int pointer1 = getHash1(key);
        int pointer2 = getHash2(key);
        if (hashArray[pointer1] == null) {
            return false;
        }
        return  hashArray[pointer1][pointer2];
    }
}
