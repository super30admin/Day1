// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {
public:
    using stack_entry_pair = std::pair<int, int> ;

    MinStack() {
        top_of_stack = -1;
    }
    
    void push(int val) {
        
        int min_val;

        if(top_of_stack == -1)
        {
            // first entry to stack. 
            // hence current val is the min val of stack
            min_val = val;

        }
        else
        {
            min_val = min_stack[top_of_stack].second;
        }
        
        
        min_val = (val < min_val) ? val : min_val;

        min_stack[++top_of_stack] = stack_entry_pair(val, min_val);

    }
    
    void pop() {
        min_stack[top_of_stack--];
    }
    
    int top() {
        return min_stack[top_of_stack].first;
    }
    
    int getMin() {
        return min_stack[top_of_stack].second;
    }
private:
    
    std::array<stack_entry_pair, 30001> min_stack;
    int top_of_stack;
};
