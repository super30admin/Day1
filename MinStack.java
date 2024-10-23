/***
 * Time Complexity : o(1)
 * Space Complexity : 0(n)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : no
 * we use single stack to store the values and mins.
 * we will push the  min even when the min and push val are equal.
 * we pop when it match
 */

class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min>=val){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop()==min){
            min = stack.pop();
        }
        
    }
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
