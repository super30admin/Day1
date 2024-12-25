// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Problem 1:(https://leetcode.com/problems/design-hashset/)
// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Code:
class MyHashSet {
    int buckets;            //Declarations
    int bucketItems;
    boolean storage[][];

    public MyHashSet() {        //Constructor to initialize variables and an array
        buckets=1000;
        bucketItems=1000;
        storage = new boolean[this.buckets][];
    }
     int getBucket(int key){         //This is the first hash function in which I am taking a modulous
        return key % this.buckets;
    }
    int getBucketItem(int key){         //This is the Second hash function in which I am dividing
        return key / this.bucketItems;
    }
    public void add(int key) {                  //whenever we have to add we will go and get the value from both the hash functions and check if 
        int bucket=getBucket(key);              //the initial array of bucket's index is null is yes then we will create an array and in that also if the index is 0 we will create an array of +1 size if we get     
        int bucketItem=getBucketItem(key);      // A number 1000000 then it won't get a index and then we will get an array index out of bound error
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]=new boolean[this.bucketItems+1];
            }
            else{
                storage[bucket]=new boolean[this.bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;       //ones the array is created and we know the index we will just make the value true. i.e element is present at that position
    }
    
    public void remove(int key) {              //To remove we will go through the first hash function and if it is null that shows value does not exists
        int bucket=getBucket(key);             //else we will go to that position and make it false. i.e the element does not exist at that position     
        if(storage[bucket]==null){
            return;
        }
        int bucketItem=getBucketItem(key);
        storage[bucket][bucketItem]=false;
    
        
    }
    
    public boolean contains(int key) {              //this function checks if the key is present or not and if present it will return true else false
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket]==null){
            return false;
        }
        return storage[bucket][bucketItem];
                
        }
    }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */




// Your code here along with comments explaining your approach
// Problem 2:(https://leetcode.com/problems/min-stack/)
// Time Complexity : O(1)
// Space Complexity :on an average it will be O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Code:
class MinStack {
    Stack<Integer> s;          //Stack and min element is declared
    int min;
    public MinStack() {       // stack and min element are initialized
        s=new Stack<>();
        min=Integer.MAX_VALUE;
        s.push(min);
    }
     
    public void push(int val) {     //for push we will chweck first if value <=min and if so we will push the min into the stack and update ,=min with val
        if(val<=min){               //Then we will push val into the stack
            s.push(min);    
            min=val;
        }
        s.push(val);
    }
    
    public void pop() {             //Here we will check if popped Value is min if so then we will pop next element and make it min
        int poppedValue=s.pop();
        if(poppedValue==min){
            min=s.pop();
        }
    }
    
    public int top() {                 //This will give the top element of the stack 
        return s.peek();
    }
    
    public int getMin() {               //As we are maintaining the min variable we will return it
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