// the stack has basic operation like described 
// we can do all this operations using different data structures 
// the primary choice for this would stack , apart from stack we can use arrays or arraylist
// as those both can access each element in O(1) time complexity
 
// now addtion to that we need to track the minimun value as well , so we will need to track the values
// we insert in stack and find the min but traversing would all takes O(n) time , 
// if we maintain a variable to track the min we can find min but as stack includes pop
// we also need to track the second lowest and further so a data strcutre would be good
// so let us create another stack to maintain and find the minumum

// now if we have multiple values with minimum we will need to push them multiple times in min stack or
// it will create problem 

class MinStack {
    stack<int>storage;
    stack<int>minStack;
public:
    MinStack() {
        
    }
    
    void push(int val) {
        // to add the value to stack
        storage.push(val);
        if(minStack.empty() || val <= minStack.top())
            minStack.push(val);
    }
    
    void pop() {
        if(!minStack.empty() && storage.top() == minStack.top())
            minStack.pop();
        storage.pop();
    }
    
    int top() {
        return storage.top();
    }
    
    int getMin() {
        return minStack.top();
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