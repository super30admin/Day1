// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : storing min values and retrieving them


// Your code here along with comments explaining your approach

class MinStack {
    int min=Integer.MAX_VALUE;
    ArrayList<Integer> arr; 
    public MinStack() {
       this.arr= new ArrayList<>();
       arr.add(min); //pushing max value to prevent empty list condition
    }
    
    public void push(int val) {
       if(val<min)
        min=val; // finding the min
    //pushing both value and current min in the ArrayList
    arr.add(val);
    arr.add(min); 
    }
    
    
    
    public void pop() {
      //popping both top value and corresponding min
       arr.remove(arr.size()-1);
       arr.remove(arr.size()-1);
       //re-assigning min after deletion
       min=arr.get(arr.size()-1);
        
    }
    
    public int top() {
    // fetching last value in ArrayList
       return arr.get(arr.size()-2);
    }
    
    public int getMin() {
        //returning min
        return min;
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