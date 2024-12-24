// Time Complexity : O(1) for every operation except pop() because after doing pop() I have to find the minimum value again
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I was unable to figure out how to do pop() in o(1) but at the same time maintain O(1) for others also. 


// Your code here along with comments explaining your approach
// Created an arraylist. All operations are O(1) because you are adding elements on last index directly and you storing the min value in some other variable. The only issue is in the get mininum part


import java.util.ArrayList;

class MinStack {
    ArrayList<Integer> list;
    int min_val = Integer.MAX_VALUE;
    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if(val < min_val){
            min_val = val;
        }
    }
    
    public void pop() {
        int removed = list.remove(list.size() - 1);
        if (removed == min_val) {
            min_val = Integer.MAX_VALUE; 
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < min_val) {
                    min_val = list.get(i); 
                }
            }
        }
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return min_val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */