import java.util.HashMap;
import java.util.Stack;

//TimeComplexity: O(1)
//SpaceComplexity: O(N) Using the HASHMAP

class MinStack {
    int min;
    Stack<HashMap<Integer, Integer>> s;
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        HashMap<Integer, Integer> newHash = new HashMap<>();
        if(val <= min) {
            min = val;
        }
        newHash.put(val,min);
        s.push(newHash);
    }
    
    public void pop() {
       s.pop();
       if (!s.isEmpty()) {
       HashMap<Integer, Integer> newHash  = s.peek();
        min = newHash.values().iterator().next();
       }else {
          min = Integer.MAX_VALUE;
       }
      
    }
    
    public int top() {
        HashMap<Integer, Integer> newHash  = s.peek();
        return newHash.keySet().iterator().next();
    }
    
    public int getMin() {
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