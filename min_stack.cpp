// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
public:
    stack<int> s;
    int min;
    MinStack() {
        min= INT_MAX;
        //s.push(min);
    }
    
    void push(int val) {
        if(val <= min){
            s.push(min);
            min = val;
        }
        else{
            s.push(val);
        }
    }
    
    void pop() {
        if(s.top()== min){
            s.pop();
            s.pop();
        }
        s.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */