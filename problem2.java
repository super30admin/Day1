// Time Complexity :
    // push() -> O(1)
    // pop() -> O(1)
    // top() -> O(1)
    // getMin() -> O(1)

// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

// 1. Store the value along with the current min seen so far in each push operation

class Element{
    private int val;
    private int min;

    public Element(int val, int min){
        this.val = val;
        this.min = min;
    }

    public int getval(){
        return this.val;
    }

    public int getmin(){
        return this.min;
    }
}

class MinStack {

    private ArrayList<Element> stack;
    private Integer min_val;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.min_val = null;    
    }
    
    public void push(int val) {
        if(this.min_val == null){
            this.min_val = val;
        }
        else if(this.min_val > val){
            this.min_val = val;
        }
        stack.add(new Element(val, min_val));
    }
    
    public void pop() {
        this.stack.remove(this.stack.size() - 1);
        if(stack.size() == 0){
            this.min_val = null;
            return;
        }

        this.min_val = this.stack.get(this.stack.size() - 1).getmin();
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1).getval();
    }
    
    public int getMin() {
        return this.stack.get(this.stack.size() - 1).getmin();
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