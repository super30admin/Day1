// Approach: first thought of maintaining a min int variable, but figured out it wont work when the min element is popped. then came up with the pairs in a stack solution. finally saw the sol and understood that it can be optimized using 2 stacks.
// Time Complexity : O(1)
// Space Complexity : O(n)

class MinStack {
public:
    MinStack() {
        
    }
    
    void push(int val) {
        stk.push(val);
        
        if (minStk.empty() || val < minStk.top().first) {
            minStk.push({val, 1});
        } else if (val == minStk.top().first) {
            minStk.top().second++;
        }
    }
    
    void pop() {
        if (stk.top() == minStk.top().first) {
            minStk.top().second--;
            if (minStk.top().second == 0) {
                minStk.pop();
            }
        }
        stk.pop();
    }
    
    int top() {
        return stk.top();
    }
    
    int getMin() {
        return minStk.top().first;
    }
private:
    stack<int> stk;
    stack<pair<int, int>> minStk;
};