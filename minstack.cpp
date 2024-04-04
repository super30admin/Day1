/* Do two stack solution
Time = O(1)
Space = O(n)
*/
class MinStack {
    stack<pair<int,int>> st;  //Stack STL which stores pairs {elem,min_elem}
    
public:
    /** initialize your data structure here. */
    MinStack() {
        
    }    
    void push(int val) {
        int temp=val;
        if(!st.empty()){
            temp = min(temp, st.top().second); //comparing to be newly pushed element with min value
        }
        st.push({val, temp});
    }
    
    void pop() {
        st.pop(); //pop
    }
    
    int top() {
        return st.top().first; //top
    }
    
    int getMin() {
        return st.top().second; //getMin
    }
};
