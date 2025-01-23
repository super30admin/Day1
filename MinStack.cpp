// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <stack>

using namespace std;
class MinStack {
    private:
    stack<int> st;
    stack<int> minSt;
    int curr_min;
public:
    MinStack() {
        curr_min = INT_MAX;
    }
    
    void push(int val) {
        if (val<=curr_min){
            minSt.push(curr_min);
            curr_min = val;
        }
        st.push(val);
    }
    
    void pop() {
        int val = st.top();
        if (curr_min == val){
            curr_min = minSt.top();
            minSt.pop();
        }
        st.pop();

    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return curr_min;
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