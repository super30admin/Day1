// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Create two stacks, one to add elements and one to keep track of min element.
// While pushing see if element is smaller than min, if yes then set is as min and push both value and min element to stack
// While poping, pop from both stacks and set min to poped element from minstack.  
class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;
 
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min); 
    }
    
    // If valu to be inserted is less than min, set min to that value.
    public void push(int val) {
        if (val < min){
            min = val;
        }
        s.push(val);
        minStack.push(min);
    }
    // Pop elements from both stacks and set min to poped element of minStack.
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
         return min;
    }
}

