// Time Complexity : O(1)
// Space Complexity : O(n) - number of elements inserted in the hashSet
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MinStack {
    // created 2 variables, minimumElement and a dynamic array
    vector<long long> minStack;
    long long minimumElement;
public:
    MinStack() {
        // initialized minimum Element
        minimumElement = 0;
    }
    
    void push(int val) {
        // if stack is empty push the element
        // and assign it as minimum element
        if (minStack.empty()) {
            minStack.push_back(val);
            minimumElement = val;
        } else if (val >= minimumElement) {
            // if the element is greater than minimum Element push it in the array
            minStack.push_back(val);
        } else {
            // else, encode the new value with the previous minimumElement and then update the minimumElement
            minStack.push_back(2 * (long long) val - minimumElement);
            minimumElement = val;
        }
    }
    
    void pop() {
        // if the top is less than miniumElement
        // assign it to minStack and then unencode it
        // assign the minimumElement back to previous value
        // Else pop it
        if (minStack.back() < minimumElement) {
            int f = minStack.back();
            minStack.pop_back();
            minimumElement = 2 * minimumElement - f;
        } else {
            minStack.pop_back();
        }
    }
    
    int top() {
        // if the top element is less than the minimumElement then just return the minimumElement
        // else return top element
        if (minStack.back() < minimumElement) {
            return minimumElement;
        } else {
            return minStack.back();
        }
    }
    
    int getMin() {
        // return minimumElement
        return (int) minimumElement;
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