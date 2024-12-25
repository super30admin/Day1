// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

class MinStack
{
public:
    stack<int> s; // declare the stack to store elements
    int min;
    MinStack()
    {
        min = INT_MAX; // initilize Minimum
        s.push(min);
    }

    void push(int val)
    {
        // update if val is new minimum
        if (val <= min)
        {
            s.push(min); // to keep track of old min
            min = val;
        }

        s.push(val);
    }

    void pop()
    {
        // update min if needed
        if (min == s.top())
        {
            s.pop();
            min = s.top();
        }
        s.pop();
    }

    int top()
    {
        // return the latest element
        return s.top();
    }

    int getMin()
    {
        // return the min element
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