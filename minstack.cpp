// Time Complexity : O(1)
// Space Complexity : O(n)  //
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach'
//i started by creating a stack pair(first,second)
// Here first is the current val(top) and second is the min
// (1) If the stack is initially empty and if there is a cmd for push we will push the ele and if the stack is empty the min will be the same element
  //  (2)If it is not empty we will push the top ele in st.first and will take min of prev min with this val and compare them and update the min
//for pop we just remove the top element
//for top we give the first as it is the top element
//for min since we were comparing all the elements and storing min in second we will return second
class MinStack {
public:
    stack<pair<int,int>>st;
    MinStack() {
        
    }
    
    void push(int val) {
        if(st.empty())st.push({val,val});
        else st.push({val, min(val,st.top().second)});
    }
    
    void pop() {
        st.pop();
    }
    
    int top() {
        return st.top().first;
    }
    
    int getMin() {
        return st.top().second;
    }
};
