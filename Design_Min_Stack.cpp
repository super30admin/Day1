class MinStack {
    int min;
    stack<int> s;
public:
    MinStack() {
        min = INT_MAX;
    }
    
    void push(int val) {
        if(val<=min){
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    void pop() {
        if(s.top() == min){
            s.pop();
            min = s.top();
            s.pop();
        }
        else{
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