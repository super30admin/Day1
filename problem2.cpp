// Designing a MinStack

//Time Complexity: O(1)
//Space Complexity: O(n)
//Code ran successfully on leetcode
//Approach: 

// I think main challenge was returning min on O(1) time. One idea was to store two vals for each node, the value and the min of 
// current val and previous val. I used a pair to acheive this. Hence I was able to get O(1) for all operations. 

class MinStack {
public:
    vector<pair<int, int>> stack; 

    MinStack() {
        
    }
    
    void push(int val) {
        if(stack.empty()){
            stack.push_back({val, val});
        }
        else{
            int temp_min = min(val, stack.back().second);
            stack.push_back({val, temp_min});
        }
    }
    
    void pop() {
        if(!stack.empty()){
            stack.pop_back();
        }
    }
    
    int top() {
        if(!stack.empty()){
            return stack.back().first;
        }
        return -1;
    }
    
    int getMin() {
        if(!stack.empty()){
            return stack.back().second;
        }
        return -1;
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