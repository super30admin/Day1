// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//HashSet
class MyHashSet {
    boolean arr[];

    public MyHashSet() {
        arr = new boolean[10000001];
    }

    public void add(int key) {
        arr[key]=true;

    }

    public void remove(int key) {
        arr[key]=false;

    }

    public boolean contains(int key) {
        return arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


// Design MinStack
class MinStack {
    Stack <int[]> stack;
    int min; // minimum value of stack
    public MinStack() {
        stack = new Stack();
    }

    public void push(int val) {
        int[] arr = new int[2];
        if( stack.isEmpty() || val <= min){
            min = val;
        }
        arr[0] = val;
        arr[1] = min;
        stack.push(arr);//arr has original value, minimum value till then
    }
    public void pop() {
        if(!stack.isEmpty()){//checking if stack is already empty
            stack.pop();
            if(!stack.isEmpty()){//checking if is empty after the above pop
                int[] st = stack.peek();//getting the top of stack with is an array.
                min = st[1];
            }
        }
    }

    public int top() {
        return stack.peek()[0];
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



