// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Node> stack;
    int min;

    public MinStack() {
        stack = new Stack<Node>();
        min = Integer.MAX_VALUE;
        stack.add(new Node(min, min));
    }
    
    public void push(int val) {
        Node peek = stack.peek();
        int minTopStack = peek.min;
        Node node = new Node(val, Math.min(minTopStack, val));
        stack.add(node);
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }
    
    public int top() {
        return (int)stack.peek().data;
    }
    
    public int getMin() {
        return (int)stack.peek().min;
    }

    class Node {
        int min;
        int data;
        public Node (int data, int min) {
            this.data = data;
            this.min = min;
        }
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

class MyHashSet {

    int bucketSize;
    int secondaryBucket;
    boolean arr[][];

    public MyHashSet() {
        this.bucketSize = 1000;
        this.secondaryBucket = 1000;
        arr = new boolean[bucketSize][];
    }

    private int primaryHashFunction(int value) {
        return value % bucketSize;
    }
    private int secondaryHashFunction(int value) {
        return value / bucketSize;
    }
    
    public void add(int key) {
        int primaryIndex = primaryHashFunction(key);
        int secondaryIndex = secondaryHashFunction(key);

        if (arr[primaryIndex] == null) {
            if (primaryIndex == 0) {
                arr[primaryIndex] = new boolean[secondaryBucket + 1];
            } else {
                arr[primaryIndex] = new boolean[secondaryBucket];
            }
        } 

        arr[primaryIndex][secondaryIndex] = true;

        return;
    }
    
    public void remove(int key) {
        int primaryIndex = primaryHashFunction(key);
        int secondaryIndex = secondaryHashFunction(key);

        if (arr[primaryIndex] == null) {
            return;
        } 

        arr[primaryIndex][secondaryIndex] = false;

        return;
    }
    
    public boolean contains(int key) {
        int primaryIndex = primaryHashFunction(key);
        int secondaryIndex = secondaryHashFunction(key);

        if (arr[primaryIndex] == null) {
            return false;
        } 

        return arr[primaryIndex][secondaryIndex];
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

