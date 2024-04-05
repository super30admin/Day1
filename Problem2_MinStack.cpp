#include <stack>

using namespace std;

class MinStack {
private:
    stack<int> st;
    stack<int> min_stack;
public:
    MinStack() {
        min_stack.push(INT_MAX);
    }
    
    void push(int val) {
        st.push(val);

        if (val < min_stack.top())
            min_stack.push(val);
        else
            min_stack.push(min_stack.top());
    }
    
    void pop() {
        min_stack.pop();
        st.pop();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return min_stack.top();
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