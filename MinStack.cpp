// Time Complexity : O(1) for all the functions: push, pop, top, getMin
// Space Complexity : O(n + n) = O(n) in the worst case(case with all elements inserted in descending order or all equal elements)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

#include<stack>
#include <limits.h>
class MinStack {
    stack<int> s;
    int min;
public:
    MinStack() {
        // Set initial min to max value
        min = INT_MAX;
    }
    
    void push(int val) {
        // If val is smaller than min, then 
        //  1. push min
        //  2. update min
        //  3. push actual val
        if (val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
        
    }
    
    void pop() {
        // Check if popped value is min,
        // if so, then pop the one below it
        // to keep track next available min
        // in the stack
        int val = s.top();
        s.pop();
        if (val == min){
            min = s.top();
            s.pop();
        }
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