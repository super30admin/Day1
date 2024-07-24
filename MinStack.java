// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : In the pop method, the condition of minimum array is empty. 
//The counter as -1 instead of 0, which is useful when pop is done.



// Your code here along with comments explaining your approach

/**
 * Problem 1: MinStack Problem
 * Implementation of min stack using 2 arrays with 2 pointers.
 * Push will store the value and push the minimum value to the minObj array.
 * Pop will remove the top-most element frm the array and also from the minObj array if it is the same value.

*/


public class MinStack {
    int[] obj;// stores all the objects.
    int[] minObj; // stores all the minimum values.
    int counter; // counter for all the stored objects.
    int minCounter; // counter for all the stored minimum value objects.
    int min;// minimum value at any time.

    public MinStack() {
        // initializations.
        counter=-1; 
        minCounter = -1;
        obj = new int[10000];
        minObj = new int[10000];
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        obj[++counter] = val;
        if(val<= min) {
            minObj[++minCounter] = val;
            min = val;
        }
    }
    
    public void pop() {
        if(obj[counter] == minObj[minCounter]) {
           --minCounter;
            if(minCounter>=0) {
                min = minObj[minCounter];
            } else { // if the min array is empty.
                min = Integer.MAX_VALUE;
            }
        }
        --counter;
    }
    
    public int top() {
        return obj[counter];
    }
    
    public int getMin() {
        if(min== Integer.MAX_VALUE) { // min array is empty
            return obj[counter];
        } else {
            return min;    
        }
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