// Time Complexity :O(1)
// Space Complexity :O(n), using 1 stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

//2nd Approach using 2 stacks
class MinStack {
//1:1 mapping, using 2 stacks
    /*Stack<Integer> mainSt;
    Stack<Integer> minSt;
    int min;
    public MinStack() {
        this.mainSt = new Stack<>();
        this.minSt = new Stack<>();
        minSt.push(Integer.MAX_VALUE);
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
       this.min  = Math.min(min,val);
        this.mainSt.push(val);
        this.minSt.push(min);


    }
    //In pop , pop from both
    public void pop() {
        mainSt.pop();
        minSt.pop();
        this.min  = minSt.peek();
    }
    
    public int top() {
        return mainSt.peek();
    }
    
    public int getMin() {
        return this.min;// minSt.peek();
    }*/


    //Using 1 stack, here whenever a curr min changes, we add the previous min under it. Also, when we pop, if its equal to curr min, pop the previous min too
    Stack<Integer> mainSt;
    int min;
    public MinStack() {
        this.mainSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    //O(1)
    public void push(int val) {
        if(val <= this.min){
            mainSt.push(min);
            min = val;

        }
        mainSt.push(val);


    }
    //O(1)
    //In pop , if pop = currmin, 
    public void pop() {
        if(mainSt.pop() == min){// check if popped elemnt is the curr min
            min = mainSt.pop();// if popped is currmin , then assign prev min as curr min
        }

    }
    //O(1)
    public int top() {
        return mainSt.peek();
    }
    //O(1)
    public int getMin() {
        return this.min;// minSt.peek();
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