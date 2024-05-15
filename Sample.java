// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Problem 1:
// Time Complexity :O(1) for searching, insertion and deletion
// Space Complexity :O(n)
// bucket and bucketList contains the range of the hashset
//using 2 dimensional array for storing the primary and secondary array
//using double hashing to store the key so that there will be no collision
class MyHashSet {
int bucket;
int bucketList;
boolean storage[][];
    public MyHashSet() {
        bucket=1000;
        bucketList=1000;
        storage=new boolean[bucket][];
    }
    
    int getBucket(int key)
    {
        return key%1000;
    }
    int getBucketItem(int key)
    {
        return key/1000;
    }
    public void add(int key) {
      int bucket=getBucket(key);
      int bucketItem= getBucketItem(key);
      if(storage[bucket]==null)
      {
        if(bucket == 0)
        {
        storage[bucket]=new boolean[bucketList + 1];
        }
        else{
            storage[bucket]=new boolean[bucketList];
        }
      }  
      storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket]==null)
        {
            return;
        }
        storage[bucket][bucketItem]=false;
    }
    
    public boolean contains(int key) {
       int bucket= getBucket(key);
       int bucketBucketItem=getBucketItem(key);
       if(storage[bucket]==null)
       {
        return false;
       } 
       return storage[bucket][bucketBucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


//Problem 2

// Time Complexity :O(1) for searching, insertion and deletion
// Space Complexity :O(n)
//The MinStack class uses two stacks: one for storing all values and another (minStack) to track the current minimum value. 
//On push, it updates and pushes the minimum value onto minStack and changes the value of min variable
// on pop, it pops from both stacks and updates the minimum. 
class MinStack {
Stack<Integer> s;
Stack<Integer> minStack;
int min;
    public MinStack() {
       s=new Stack<>();
       minStack=new Stack<>();
       min=Integer.MAX_VALUE;
       minStack.push(min); 
    }
    
    public void push(int val) {
       if(val<=min)
       {
        min=val;
       } 
       minStack.push(min);
       s.push(val);
    }
    
    public void pop() {
       minStack.pop();
       s.pop();
       min=minStack.peek(); 
    }
    
    public int top() {
      return s.peek();  
    }
    
    public int getMin() {
      return min;  
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