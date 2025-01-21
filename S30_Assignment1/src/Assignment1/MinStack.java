package Assignment1;
import java.util.*;
/* Time Complexity : O(1) for every operation as we are using two arraylists to maintain the min and stack;
 * */
/* Space Complexity : O(n) as we are maintaining two arrays of size n;
 * */
// Did this code successfully run on Leetcode : yes, it is accepted.
// Any problem you faced while coding this : no.



// Your code here along with comments explaining your approach
public class MinStack {
	//this list is for normal stack.
	List<Integer> stk;
	//this is for maintaining the minimum value till that particular index.
    List<Integer> min;
    
    public MinStack() {
        stk = new ArrayList<>();
        min = new ArrayList<>();
    }
    //this method adds the element at the end of the arraylist and maintains the minimum value by comparing with top element in the min list.
    public void push(int val) {
        stk.add(val);
        if(min.isEmpty())
            min.add(val);
        else
           min.add(Math.min(getMin(), val)); 
    }
    //this pop method removes the last element from the stk list and also from the min list
    public void pop() {
        if(!stk.isEmpty())
        {
            stk.remove(stk.size()-1);
            min.remove(min.size()-1);
        }
    }
    //top just returns the last element from the stk, if stk is not empty;
    public int top() {
        if(!stk.isEmpty())
            return stk.get(stk.size()-1);
        return 0;
    }
    //getmin method returns the last element from the min list, if it is not empty.
    public int getMin() {
        if(!min.isEmpty())
        return min.get(min.size()-1);
        return 0;
    }
}
