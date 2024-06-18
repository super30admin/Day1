class MinStack {
    public:
    std::vector<int> stack;
    std::vector<int> minValue;
    MinStack() {

    }

    void push(int val) {
        if(stack.size()==0){
            stack.push_back(val);
            minValue.push_back(val);
        }else{
            int min = minValue.back();
            stack.push_back(val);
            if(std::min(val, min) == val){
                minValue.push_back(val);
            }else{
                minValue.push_back(min);
            }
        }
    }

    void pop() {
        minValue.pop_back();
        stack.pop_back();
    }

    int top() {
        return stack.back();
    }

    int getMin() {
        return minValue.back();
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