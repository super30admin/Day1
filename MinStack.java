// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
import java.util.*;
class MinStack {

    Stack<Integer> minst;
       int currMin;

   public MinStack() {

       this.minst = new Stack<>();
       this.currMin = Integer.MAX_VALUE;
      
       
   }
   
   public void push(int val) {
       
       if(currMin >= val){
           minst.push(currMin);
           currMin = val;
       }
       minst.push(val);
       
   }
   
   public void pop() {
       int top = minst.pop();
       if(top == currMin){
           currMin = minst.pop();
       }
       
       
   }
   
   public int top() {
       return minst.peek();
   }
   
   public int getMin() {
       return currMin;
       
   }
}
